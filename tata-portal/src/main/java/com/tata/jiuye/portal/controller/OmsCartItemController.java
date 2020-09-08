package com.tata.jiuye.portal.controller;

import com.tata.jiuye.common.api.CommonResult;
import com.tata.jiuye.common.exception.Asserts;
import com.tata.jiuye.model.OmsCartItem;
import com.tata.jiuye.model.UmsMember;
import com.tata.jiuye.portal.domain.CartProduct;
import com.tata.jiuye.portal.domain.CartPromotionItem;
import com.tata.jiuye.portal.service.OmsCartItemService;
import com.tata.jiuye.portal.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车管理Controller
 * Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "OmsCartItemController", description = "购物车管理")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class OmsCartItemController {
    @Resource
    private  UmsMemberService memberService;
    @Resource
    private  OmsCartItemService cartItemService;

    /*@ApiOperation("添加商品到购物车")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody OmsCartItem cartItem) {
        UmsMember currentMember = memberService.getCurrentMember();
        if(currentMember == null){
            return CommonResult.failed("用户未登录");
        }
        int count = cartItemService.add(cartItem,currentMember);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }*/


    @ApiOperation("添加商品到购物车")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestParam @ApiParam("商品ID")Long productId, @RequestParam @ApiParam("购买数量")Integer quantity, @RequestParam @ApiParam("商品库存ID") Long productSkuId) {
        UmsMember currentMember = memberService.getCurrentMember();
        if(currentMember == null){
            return CommonResult.failed("用户未登录");
        }
        int count = cartItemService.add(productId,productSkuId,quantity,currentMember);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取某个会员的购物车列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCartItem>> list() {
        List<OmsCartItem> cartItemList = cartItemService.list(memberService.getCurrentMember().getId());
        return CommonResult.success(cartItemList);
    }

    @ApiOperation("获取某个会员的购物车列表,包括促销信息")
    @RequestMapping(value = "/list/promotion", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CartPromotionItem>> listPromotion(@RequestParam(required = false) List<Long> cartIds) {
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(memberService.getCurrentMember().getId(), cartIds);
        return CommonResult.success(cartPromotionItemList);
    }

    @ApiOperation("修改购物车中某个商品的数量")
    @RequestMapping(value = "/update/quantity", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateQuantity(@RequestParam @ApiParam("购物车ID") Long id,
                                       @RequestParam @ApiParam("修改后的数量")Integer quantity) {
        int count = cartItemService.updateQuantity(id, memberService.getCurrentMember().getId(), quantity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取购物车中某个商品的规格,用于重选规格")
    @RequestMapping(value = "/getProduct/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CartProduct> getCartProduct(@PathVariable Long productId) {
        CartProduct cartProduct = cartItemService.getCartProduct(productId);
        return CommonResult.success(cartProduct);
    }

    @ApiOperation("修改购物车中商品的规格")
    @RequestMapping(value = "/update/attr", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateAttr(@RequestBody OmsCartItem cartItem) {
        UmsMember currentMember = memberService.getCurrentMember();
        if(currentMember == null){
            return CommonResult.failed("用户未登录");
        }
        int count = cartItemService.updateAttr(cartItem,currentMember);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除购物车中的某个商品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestBody List<Long> ids) {
        UmsMember currentMember = memberService.getCurrentMember();
        if(currentMember == null){
            Asserts.fail("用户未登录");
        }
        int count = cartItemService.delete(currentMember.getId(), ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("清空购物车")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult clear() {
        int count = cartItemService.clear(memberService.getCurrentMember().getId());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
