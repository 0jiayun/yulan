package com.yulan.controller;

import com.yulan.service.YLc_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("Ylc_info")
public class YLc_infoController {
    @Autowired
    private YLc_infoService yLc_infoService;

    @RequestMapping("getAllyf")
    @ResponseBody
    public Map getAll(@RequestParam(name = "limit", required = false) Integer limit,
                      @RequestParam(name = "page", required = false) Integer page,
                      @RequestParam("year")String year,
                      @RequestParam("infoState")String infoState,
                      @RequestParam("ylcState")String ylcState,
                      @RequestParam("find")String find) throws UnsupportedEncodingException {
        if (year==null||year.equals("")){
            year=null;
        }
        if (infoState.equals("")){
            infoState=null;
        }
        if (ylcState.equals("")){
            ylcState=null;
        }
        if (find.equals("")){
            find=null;
        }

        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit+1;
        }
        int lastNum=page+limit-1;

        Map map=yLc_infoService.getAllYLc_info(page,lastNum ,year,infoState,ylcState,find);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @RequestMapping("getAllf")
    @ResponseBody
    public Map getAllf(@RequestParam(name = "limit", required = false) Integer limit,
                      @RequestParam(name = "page", required = false) Integer page,
                      @RequestParam("year")String year,
                      @RequestParam("infoState")String infoState,
                       @RequestParam("cid")String cid,
                      @RequestParam("find")String find) throws UnsupportedEncodingException {
        if (year==null||year.equals("")){
            year=null;
        }
        if (infoState.equals("")){
            infoState=null;
        }

        if (find.equals("")){
            find=null;
        }
        if(cid.equals("")){
            cid=null;
        }

        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit+1;
        }
        int lastNum=page+limit-1;

        Map map=yLc_infoService.getAllinfo(page,lastNum ,year,infoState,find,cid);
        map.put("code",0);
        map.put("msg","");
        return map;
    }
}
