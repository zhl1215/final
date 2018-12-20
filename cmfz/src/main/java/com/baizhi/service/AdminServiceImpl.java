package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


//此处缺少正确的事务控制

    public String testLogin(String phone, String password, String validateCode, HttpSession session) {
        //先判断验证码是否正确
        System.out.println("1");
        String code = (String) session.getAttribute("code");
        if(!validateCode.equals(code)) return "code is not true";
        //数据库通过phone查询一个用户
        System.out.println("2");

        Admin admin = adminMapper.selectOneByPhone(phone);
        if(admin ==null) return "admin doesnt exist";
        System.out.println("user不为空");
        System.out.println(admin);

        String phone2 = admin.getPhone();

        String password2 = admin.getPassword();

        Boolean bb = Md5Util.checkPassword(password,password2);
        if(!bb) return "password is wrong";
        return "ok";
    }
}
