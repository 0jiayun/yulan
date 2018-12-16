package com.yulan.controller;

import com.yulan.pojo.Web_user;
import com.yulan.service.Web_userService;
import com.yulan.utils.Response;
import com.yulan.utils.TimeUtil;
import com.yulan.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("web_user")
public class Web_userController {
    private Map<String, HttpSession> sessions = new HashMap<String,HttpSession>();
    @Autowired
    private Web_userService web_userService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(loginName);
        Web_user web_user = web_userService.login(loginName,password);
        if(web_user==null) {
            Map map= Response.getResponseMap(1,"账号与密码不相符",null);
            return map;
        }
        else {
           /* int code=1;
            switch (web_user.getType()){
                case "ADMIN": code=1;break;
                case  "ECWEB":code=2;break;
                case  "SUPLY":code=3;break;
                case  "SALEMAN":code=4;break;
                case  "QUERY":code=5;break;
            }*/
            Map map=Response.getResponseMap(0,"",web_user);
            String token= Token.createToken(web_user);
            HttpSession session = request.getSession();
            /*session.setAttribute("token",token);
            sessions.put(token,session);*/
            map.put("token", token );
            map.put("logintime", TimeUtil.getTime());
            return map;
        }
    }
    @RequestMapping("exit")
    @ResponseBody
    public Map<String,Object> exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if(sessions.containsKey(token)) {
            session.invalidate();
            sessions.remove(token);
            return Response.getResponseMap(0,"退出成功",null);
        } else {
            return Response.getResponseMap(1,"用户未登录",null);
        }
    }

}
