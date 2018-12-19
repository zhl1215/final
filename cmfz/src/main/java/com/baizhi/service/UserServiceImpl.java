package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import com.baizhi.util.Md5Util;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserMapper userMapper;


//此处缺少正确的事务控制

    public String testLogin(String phone, String password, String validateCode, HttpSession session) {
        //先判断验证码是否正确
        System.out.println("1");
        String code = (String) session.getAttribute("code");
        if(!validateCode.equals(code)) return "code is not true";
        //数据库通过phone查询一个用户
        System.out.println("2");

        User user = userMapper.selectOneByPhone(phone);
        if(user==null) return "user doesnt exist";
        System.out.println("user不为空");
        System.out.println(user);

        String phone2 = user.getPhone();

        String password2 = user.getPassword();

        Boolean bb = Md5Util.checkPassword(password,password2);
        if(!bb) return "password is wrong";
        return "ok";
    }
}
