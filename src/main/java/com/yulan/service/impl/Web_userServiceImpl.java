package com.yulan.service.impl;

import com.yulan.dao.Web_userDao;
import com.yulan.pojo.Web_user;
import com.yulan.service.Web_userService;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class Web_userServiceImpl implements Web_userService {
    @Autowired
    private Web_userDao web_userDao;

    @Override
    public Web_user login(String loginName, String password) throws UnsupportedEncodingException {
        if (password.equals("123456")){
            Web_user web_user=web_userDao.login(loginName,password);
            if(web_user!=null){

                web_user.setCompany(StringUtil.getUtf8(web_user.getCompany()));
                web_user.setRealName(StringUtil.getUtf8(web_user.getRealName()));
            }

            return web_user;
        }

        return null;
    }
}
