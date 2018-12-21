package com.yulan.dao;

import org.apache.ibatis.annotations.Param;
import  com.yulan.pojo.Web_user;
public interface Web_userDao {


    //登陆
    Web_user login(@Param("loginName")String loginName,@Param("password")String password);

    //检查账号密码
    String check(String loginName);

    //
    boolean updateuserState(@Param("userState")String userState,@Param("cid")String cid);

    Web_user getUser(@Param("cid")String cid);

    String getPosition(@Param("cid")String cid,@Param("year")Integer year);
}
