package com.baizhi.service;

import javax.servlet.http.HttpSession;

public interface UserService {
    //登陆验证

    public  String testLogin(String phone ,String password,String validateCode, HttpSession session);

}
