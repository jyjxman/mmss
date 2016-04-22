package com.mmss.mapper;

import com.mmss.pojo.SysPurBusListAudit;
import com.mmss.pojo.SysPurBusListAuditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPurBusListAuditMapper {
    int countByExample(SysPurBusListAuditExample example);

    int deleteByExample(SysPurBusListAuditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPurBusListAudit record);

    int insertSelective(SysPurBusListAudit record);

    List<SysPurBusListAudit> selectByExample(SysPurBusListAuditExample example);

    SysPurBusListAudit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPurBusListAudit record, @Param("example") SysPurBusListAuditExample example);

    int updateByExample(@Param("record") SysPurBusListAudit record, @Param("example") SysPurBusListAuditExample example);

    int updateByPrimaryKeySelective(SysPurBusListAudit record);

    int updateByPrimaryKey(SysPurBusListAudit record);
}