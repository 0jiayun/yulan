package com.yulan.dao;

import org.apache.ibatis.annotations.Param;
import  com.yulan.pojo.Web_user;
public interface Web_userDao {


    //登陆
    Web_user login(@Param("loginName")String loginName,@Param("password")String password);

    //检查账号密码
    String check(String loginName);
}
