package com.pps.back.frame.pupansheng.controller;

import com.pps.back.frame.pupansheng.common.model.Result;
import com.pps.back.frame.pupansheng.security.entity.SysPermisson;
import com.pps.back.frame.pupansheng.security.entity.SysRole;
import com.pps.back.frame.pupansheng.security.entity.SysUser;
import com.pps.back.frame.pupansheng.security.mapper.SysPermissonDao;
import com.pps.back.frame.pupansheng.security.mapper.SysRoleDao;
import com.pps.back.frame.pupansheng.security.mapper.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @discription;
 * @time 2020/8/27 17:07
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    SysPermissonDao sysPermissonDao;
    @Autowired
    SysRoleDao sysRoleDao;
    @Autowired
    SysUserDao sysUserDao;

    @RequestMapping("/getLoginInfo")//登陆获得自己登录信息
    public Result getLoginInfo(){
        Map info=new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username= (String) authentication.getPrincipal();
        SysUser sysUser =new SysUser() ;
        sysUser.setName(username);
        SysUser sysUser1 = sysUserDao.queryCondition(sysUser).get(0);
        sysUser1.setPassword("");
        List<SysRole> sysRoles =sysRoleDao.queryRoleByUserId(sysUser1.getId());
        info.put("userInfo",sysUser1);
        info.put("roles", sysRoles);
        List<SysPermisson> sysPermissons=new ArrayList<>();
        sysRoles.stream().forEach(p->{
            List<SysPermisson> sysPermissons1 = sysPermissonDao.queryPermissonByRoleId(p.getId());
            sysPermissons.addAll(sysPermissons1);
        });
        info.put("permission",sysPermissons);
        return  Result.ok(info);
    }


}
