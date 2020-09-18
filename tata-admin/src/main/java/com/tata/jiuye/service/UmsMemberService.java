package com.tata.jiuye.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tata.jiuye.DTO.UmsMemberInfoByMemberIdResult;
import com.tata.jiuye.model.UmsMember;

public interface UmsMemberService extends IService<UmsMember> {

    public UmsMemberInfoByMemberIdResult getUmsInfoByMemberId(Long memberId);


    Long getSuperiorDistributionCenterMemberId(Long memberId);
}