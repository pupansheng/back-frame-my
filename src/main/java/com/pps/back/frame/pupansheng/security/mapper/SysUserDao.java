package com.pps.back.frame.pupansheng.security.mapper;

import com.pps.back.frame.pupansheng.security.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> queryCondition(SysUser sysUser);
}