package com.tata.jiuye.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.tata.jiuye.common.api.CommonPage;
import com.tata.jiuye.common.api.CommonResult;
import com.tata.jiuye.mapper.OmsDistributionMapper;
import com.tata.jiuye.model.*;
import com.tata.jiuye.portal.domain.HomeContentResult;
import com.tata.jiuye.portal.service.HomeService;
import com.tata.jiuye.portal.util.aliyunOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 小程序首页
 *
 * @author lewis
 */
@Controller
@Api(tags = "HomeController", description = "小程序首页")
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    @Resource
    private  HomeService homeService;

    @Resource
    private aliyunOssUtil aliyunOssUtil;

    @Resource
    private OmsDistributionMapper distributionMapper;

    @ApiOperation("首页内容页信息展示")
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeContentResult> content() {
        return CommonResult.success(homeService.content());
    }

    @ApiOperation("分页获取推荐商品")
    @RequestMapping(value = "/recommendProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> recommendProductList(@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = homeService.recommendProductList(pageSize, pageNum);
        return CommonResult.success(productList);
    }

    @ApiOperation("获取首页商品分类")
    @RequestMapping(value = "/productCateList/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategory>> getProductCateList(@PathVariable Long parentId) {
        List<PmsProductCategory> productCategoryList = homeService.getProductCateList(parentId);
        return CommonResult.success(productCategoryList);
    }

    @ApiOperation("根据分类获取专题")
    @RequestMapping(value = "/subjectList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> getSubjectList(@RequestParam(required = false) Long cateId,
                                                         @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubject> subjectList = homeService.getSubjectList(cateId, pageSize, pageNum);
        return CommonResult.success(subjectList);
    }

    @ApiOperation("分页获取人气推荐商品")
    @RequestMapping(value = "/hotProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> hotProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        List<PmsProduct> productList = homeService.hotProductList(pageNum, pageSize);
        return CommonResult.success(productList);
    }

    @ApiOperation("分页获取新品推荐商品")
    @RequestMapping(value = "/newProductList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProduct>> newProductList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        List<PmsProduct> productList = homeService.newProductList(pageNum, pageSize);
        return CommonResult.success(productList);
    }

    @ApiOperation("分页获取分类商品")
    @RequestMapping(value = "/classifiedProductPage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult classifiedProductPage(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "10") @ApiParam("每页条数") Integer pageSize,
                                              @RequestParam @ApiParam("商品分类ID") Long productCategoryId) {
        CommonPage<PmsProduct> resultPage = homeService.getPmsProductByProductCategoryId(pageNum, pageSize, productCategoryId);
        return CommonResult.success(resultPage);
    }

    @ApiOperation("获取城市列表")
    @RequestMapping(value = "/queryCity", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryCity() {
        List<area> areas=homeService.queryAllCityName();
        return CommonResult.success(areas);
    }


    @ApiOperation("获取地区列表")
    @RequestMapping(value = "/queryArea", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult queryArea(String city) {
        List<area> areas=homeService.queryAllareaName(city);
        return CommonResult.success(areas);
    }

    @ApiOperation("上传文件接口")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(MultipartFile[] files)throws IOException {
        JSONObject obj = new JSONObject();
        List<String> imgPath = new ArrayList<>();
        if (null != files && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                String fileName = String.valueOf(System.currentTimeMillis());
                MultipartFile file = files[i];
                InputStream ins = null;
                ins = file.getInputStream();
                File tofile=new File(file.getOriginalFilename());
                try{
                    OutputStream os = new FileOutputStream(tofile);
                    int bytesRead = 0;
                    byte[] buffer = new byte[8192];
                    while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    os.close();
                    ins.close();
                }catch (Exception e){

                }
                //保存文件
                String  imagePath=aliyunOssUtil.uploadFile(tofile,fileName);
                imgPath.add(imagePath);
                //删除临时文件
                tofile.delete();
            }

        }
        obj.put("imgPath", imgPath);
        return CommonResult.success(obj);
    }


}
