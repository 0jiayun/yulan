package com.yulan.service;

import com.yulan.pojo.Web_user;

import java.io.UnsupportedEncodingException;

public interface Web_userService {
    Web_user login(String loginName,String password) throws UnsupportedEncodingException;


}
