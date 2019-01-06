package com.yulan.service.impl;

import com.yulan.dao.Web_userDao;
import com.yulan.pojo.Web_user;
import com.yulan.service.Web_userService;
import com.yulan.utils.Response;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class Web_userServiceImpl implements Web_userService {
    @Autowired
    private Web_userDao web_userDao;

    @Override
    public Map login(String loginName, String password,Integer year) throws UnsupportedEncodingException {
        Map map=new HashMap();
        if (password.equals("123456")){

            Web_user web_user=web_userDao.login(loginName,password);
            if(web_user!=null){
                String position=web_userDao.getPosition(web_user.getLoginName(),year);
                web_user.setCompany(StringUtil.getUtf8(web_user.getCompany()));
                web_user.setRealName(StringUtil.getUtf8(web_user.getRealName()));
                if(position==null){
                    map.put("position","");
                }else{
                    map.put("position",StringUtil.getUtf8(position));
                }

                map.put("data",web_user);
                map.put("code",0);
                return map;
            }



        }

        return null;
    }

    @Override
    public Map updateuserState(String userState, String cid,Integer year) throws UnsupportedEncodingException {
        Map<String,Object> map=new HashMap<>();
        if (web_userDao.updateuserState(userState,cid)){
            String position=web_userDao.getPosition(cid,year);
            Web_user web_user=web_userDao.getUser(cid);
            map.put("position",StringUtil.getUtf8(position));
            map.put("data",web_user);
            map.put("code",0);
            map.put("msg","修改成功");
        }else {
            map= Response.getResponseMap(1,"修改失败",null);
        }
        return map;
    }
}
