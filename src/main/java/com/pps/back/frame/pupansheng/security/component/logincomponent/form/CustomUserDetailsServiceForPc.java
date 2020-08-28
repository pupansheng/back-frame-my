package com.pps.back.frame.pupansheng.security.component.logincomponent.form;

import com.pps.back.frame.pupansheng.security.component.exception.ServiceException;
import com.pps.back.frame.pupansheng.security.entity.SysRole;
import com.pps.back.frame.pupansheng.security.entity.SysUser;
import com.pps.back.frame.pupansheng.security.mapper.SysRoleDao;
import com.pps.back.frame.pupansheng.security.mapper.SysUserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author
 * @discription;
 * @time 2020/5/13 16:51
 */
@Service(value = "customUserDetailsServiceForPc")
@Slf4j
public class CustomUserDetailsServiceForPc implements UserDetailsService {

    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysRoleDao sysRoleDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws ServiceException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser sysUser=new SysUser();
        sysUser.setName(username);
        List<SysUser> user = sysUserDao.queryCondition(sysUser);
        // 判断用户是否存在
        if(user==null||user.size()<=0) {
                throw new UsernameNotFoundException("用户不存在");
        }
        // 添加权限
        if(user.size()>1){

            throw new UsernameNotFoundException("用户存在多个 不合规范！！！！");

        }
        SysUser logUser=user.get(0);

        //获得角色信息
        List<SysRole> sysRole = sysRoleDao.queryRoleByUserId(logUser.getId());

        //给予角色
        sysRole.stream().forEach(p->{

            authorities.add(new SimpleGrantedAuthority(p.getName()));

        });
        // 返回UserDetails实现类
        return new User(logUser.getName(), logUser.getPassword(), authorities);
    }
}
