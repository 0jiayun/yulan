package com.yulan.controller;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontractentry;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.InfoStateService;
import com.yulan.service.YLcontractentryService;
import com.yulan.utils.Response;
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

    private YLcontractentry yLcontractentry;
    @Autowired
    private InfoStateService infoStateService;
    @Autowired
    private YLcontractentryService yLcontractentryService;
    @Autowired
    private CustomerInfoService customerInfoService;

    private CustomerInfoCard customerInfoCard;

    private Response response;

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

            String customerInfo = null;
            customerInfoCard = customerInfoService.getCustomerInfo(cid);
            String customerInfoCardState = customerInfoCard.getState();
            String customerMemo =  customerInfoCard.getMemo();;

            yLcontractentry = yLcontractentryService.getYLcontractentry(cid);
            String yLcontractentryState = yLcontractentry.getState();
            String yLcontractInfo = null;
            String yLcontractMemo = yLcontractentry.getWfmemo();

            if(customerInfoCardState.equals("CUSTOMERPORCESSING2")){
                customerInfo = "资料卡被退回请重新填写";

            }else{
                customerInfo = "暂无最新消息";
            }
            if(yLcontractentryState.equals("CUSTOMERAFFIRM")){
                yLcontractInfo = "协议书已发下，请尽快确认";
            }else{
                yLcontractInfo = "暂无最新消息";
            }
            map.put("customerInfoCardState",customerInfo);
            map.put("customerMemo",customerMemo);
            map.put("yLcontractState",yLcontractInfo);
            map.put("yLcontractMemo",yLcontractMemo);

            return map;
    }

    /**
     * 客户资料卡评审记录
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getCustomerInfoCardState")
    @ResponseBody
    public Map getCustomerInfoCardState(@RequestBody Map<String,Object> data)throws IOException{
        String cid = (String)data.get("cid");
        Map<String,Object> map = new HashMap<>();
        map = infoStateService.getCustomerInfoCardState(cid);
        return map;
    }

    /**
     * 协议书评审记录
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "getYLcontractentryState")
    @ResponseBody
    public Map getYLcontractentryState(@RequestBody Map<String,Object> data)throws IOException{
        String cid = (String)data.get("cid");
        Map<String,Object> map = new HashMap<>();
        map = infoStateService.getYLcontractState(cid);
        return map;
    }

    /**
     * 业务员/订单部审核资料卡
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "bussinessCheckCustomerInfoCard")
    @ResponseBody
    public Map businessCheckCustomerInfoCard(@RequestBody Map<String,Object> data)throws IOException{
        String cid = (String)data.get("cid");
        String state = (String)data.get("state");
        String memo = (String)data.get("memo");
        if(infoStateService.businessCheckCustomerInfoCard(cid,state,memo)){
            return response.getResponseMap(0,"SUCCESS" ,null);
        }else{
            return response.getResponseMap(1,"更新失败" ,null);
        }
    }

    /**
     * 协议书审查接口
     * @param data
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "checkYLcontractentryState")
    @ResponseBody
    public Map checkYLcontractentryState(@RequestBody Map<String,Object> data)throws IOException{
        String cid = (String)data.get("cid");
        String state = (String)data.get("state");
        String wfmemo = (String)data.get("wfmemo");
        if(infoStateService.checkYLcontractentryState(cid,state,wfmemo)){
            return response.getResponseMap(0,"SUCCESS" ,null);
        }else{
            return response.getResponseMap(1,"更新失败" ,null);
        }
    }
}
