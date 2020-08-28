package com.pps.back.frame.pupansheng.controller;


import com.pps.back.frame.pupansheng.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @discription;
 * @time 2020/5/13 15:13
 */
@RestController
@RequestMapping("/pc")
public class TestController {




    @RequestMapping("/test/test1")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Result test1(){



        return  Result.ok("admin才能访问 角色：");




    }

    @RequestMapping("/test/test2")
    @PreAuthorize("hasRole('ROLE_USER')")//@PreAuthorize 用于判断用户是否有指定权限，没有就不能访问
    public Result test2(){

        return  Result.ok("user 角色才能访问：");



    }

    @RequestMapping("/test/test3")
    @PreAuthorize("hasPermission('/project/pc/test/test3','r')")
    public Result test3(){

        return  Result.ok("/对当前路径 r权限："+SecurityContextHolder.getContext().getAuthentication());


    }
    @RequestMapping("/test/test4")
    @PreAuthorize("hasPermission('/project/pc/test/test3','x')")
    public Result test7(){


        return  Result.ok("对当前访问路径具有 x权限：");


    }
    @RequestMapping("/test1/test5")
    public Result test8(){

        return  Result.ok("无登录限制：");


    }









}
