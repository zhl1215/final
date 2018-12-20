package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminMapper adminMapper;
    //前台测试应该是发ajax

    @RequestMapping("/login")
    public String login(String phone, String password, String validateCode, HttpSession session){
        //获得前台提供的账号和密码以及验证码进行验证
        //表单提交，发送ajax，进行验证
        System.out.println("进入Controller");
        System.out.println(phone+"-"+password+"-"+validateCode+"-"+session);
        String msg= adminService.testLogin(phone,password,validateCode,session);
        System.out.println(msg);
        System.out.println("出Controller");
        if(msg.equals("ok")){
            //存储标志
            Admin admin = adminMapper.selectOneByPhone(phone);
            session.setAttribute("user", admin);
            return "/main/main";
        }else{
            //提示信息存入session
            session.setAttribute("message",msg);
            //跳转到登录页面
            return "/login";
        }

        //校验验证码
        //校验用户是否存在
        //校验密码是否正确


    }


}
