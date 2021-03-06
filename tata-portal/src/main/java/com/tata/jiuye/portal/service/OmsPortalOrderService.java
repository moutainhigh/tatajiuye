package com.tata.jiuye.portal.service;

import com.alibaba.fastjson.JSONObject;
import com.tata.jiuye.common.api.CommonPage;
import com.tata.jiuye.model.OmsOrder;
import com.tata.jiuye.model.UmsMember;
import com.tata.jiuye.portal.domain.ConfirmOrderResult;
import com.tata.jiuye.portal.domain.OmsOrderDetail;
import com.tata.jiuye.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 根据用户购物车信息生成确认单信息
     * @param cartIds
     */
    ConfirmOrderResult generateConfirmOrder(List<Long> cartIds);

    /**
     * 根据提交信息生成订单
     * @param currentMember         当前登录人
     * @param orderParam            订单信息
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam, UmsMember currentMember);

    /**
     * 支付成功后的回调
     */
    @Transactional
    Integer paySuccess(Long orderId, Integer payType);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 确认收货
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 分页获取用户订单
     */
    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     */
    OmsOrderDetail detail(Long orderId);

    /**
     * 用户根据订单ID删除订单
     */
    void deleteOrder(Long orderId);

    /**
     * 根据订单号获取订单对象
     * @param orderSn               订单号
     * @return
     */
    OmsOrder getOmsOrderByOrderSn(String orderSn);

    Map<String,Object> queryOrderCount();

    JSONObject queryDistribution();
}
