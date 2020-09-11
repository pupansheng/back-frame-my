package com.pps.back.frame.pupansheng.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @discription;
 * @time 2020/8/27 16:22
 */
@Controller
@ConditionalOnProperty(name = "mysecurity.sms.openSms",havingValue = "true")
@ConditionalOnClass
public class ValidationCodeController {

    @RequestMapping("/sms/get/yanzhengma")
    @ResponseBody
    public String getMessageCode(String phone, HttpServletRequest httpServletRequest){

        Map map=new HashMap();
        map.put("code",phone);
        map.put("phone",phone);
        httpServletRequest.getSession().setAttribute("code",map);
        return "发送成功";
    }
}
