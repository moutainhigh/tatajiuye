package com.tata.jiuye.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tata.jiuye.model.AcctInfo;
import com.tata.jiuye.model.AcctInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AcctInfoMapper extends BaseMapper<AcctInfo> {
    long countByExample(AcctInfoExample example);

    int deleteByExample(AcctInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcctInfo record);

    int insertSelective(AcctInfo record);

    List<AcctInfo> selectByExample(AcctInfoExample example);

    AcctInfo selectByPrimaryKey(Long id);
    AcctInfo selectByUmsId(Long id);
    AcctInfo selectByWmsId(Long id);

    int updateByExampleSelective(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByExample(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByPrimaryKeySelective(AcctInfo record);

    int updateByPrimaryKey(AcctInfo record);

    /**
     * 通过用户ID获取账户
     * @return
     */
    AcctInfo getByMemberIdAndAcctType(Map<String,Object> params);
}
