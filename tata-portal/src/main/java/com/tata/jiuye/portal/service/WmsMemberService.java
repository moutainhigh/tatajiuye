package com.tata.jiuye.portal.service;

import com.alibaba.fastjson.JSONObject;
import com.tata.jiuye.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface WmsMemberService {

    JSONObject selectMerberInfo();

    List<WmsMemberAreaDetail> queryAllUser();

    List<WmsArea> queryAllArea();

    void changeDistribution(Long changeId,Long orderId);

    void acceptOrder(Long orderId);

    void cancelReplenishable(Long id,String type);

    void arriveOrder(Long orderId);

    void replenishable(List<ProductParams>  params);

    void shipment(Long id,Integer number);

    void replenishableCheck(Long id,List<String> imgs);

    List<PmsProduct>  queryReplenishableList();

    @Transactional
    WmsMember insertWmsMember(UmsMember umsMember, BigDecimal creditLine);
}
