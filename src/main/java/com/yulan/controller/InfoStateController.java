package com.yulan.controller;

import com.yulan.service.InfoStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("infoState")
public class InfoStateController {
    @Autowired
    private InfoStateService infoStateService;

    /**
     * 获取公告信息
     * 1.资料卡是否退回
     * 2.协议书是否发下
     * @param data
     * @return
     */
    @RequestMapping(value = "getNoticeInfo")
    @ResponseBody
    public Map getNoticeInfo(@RequestBody Map<String,Object> data)throws IOException {
            Map<String,Object> map = new HashMap<>();
            String cid = (String)data.get("cid");
            String customerInfoCardState = infoStateService.getCustomerInfoCardState(cid);
            String yLcontractState = infoStateService.getYLcontractState(cid);
            String customerInfo = null;
            String yLcontractInfo = null;

            if(customerInfoCardState.equals("CUSTOMERPORCESSING2")){
                customerInfo = "资料卡被退回请重新填写";
            }else{
                customerInfo = "暂无最新消息";
            }
            if(yLcontractState.equals("CUSTOMERAFFIRM")){
                yLcontractInfo = "协议书已发下，请尽快确认";
            }else{
                yLcontractInfo = "暂无最新消息";
            }
            map.put("customerInfoCardState",customerInfo);
            map.put("yLcontractState",yLcontractInfo);

            return map;
    }
}
