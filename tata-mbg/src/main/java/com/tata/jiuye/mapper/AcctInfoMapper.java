package com.tata.jiuye.mapper;

import com.tata.jiuye.model.AcctInfo;
import com.tata.jiuye.model.AcctInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcctInfoMapper {
    long countByExample(AcctInfoExample example);

    int deleteByExample(AcctInfoExample example);

    int deleteByPrimaryKey(String acctId);

    int insert(AcctInfo record);

    int insertSelective(AcctInfo record);

    List<AcctInfo> selectByExample(AcctInfoExample example);

    AcctInfo selectByPrimaryKey(String acctId);

    int updateByExampleSelective(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByExample(@Param("record") AcctInfo record, @Param("example") AcctInfoExample example);

    int updateByPrimaryKeySelective(AcctInfo record);

    int updateByPrimaryKey(AcctInfo record);
}