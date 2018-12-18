package com.yulan.service.impl;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontractentry;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.InfoStateService;
import com.yulan.service.YLcontractentryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InfoStateServiceImpl implements InfoStateService {
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private YLcontractentryService yLcontractentryService;

    private YLcontractentry yLcontractentry;

    private CustomerInfoCard customerInfoCard;

    @Override
    public String getCustomerInfoCardState(String cid) throws IOException {
        String customerInfo = null;
        customerInfoCard = customerInfoService.getCustomerInfo(cid);
        String customerInfoCardState = customerInfoCard.getState();

        if(customerInfoCardState.equals("CUSTOMERPORCESSING2")){
            customerInfo = "资料卡被退回请重新填写";
        }else if(customerInfoCardState.equals("BUSINESSCHECKING")){
            customerInfo = "业务员审核中";
        }else if(customerInfoCardState.equals("APPROVED")){
            customerInfo = "资料卡通过";
        }else{
            customerInfo = "暂无最新消息";
        }
        return customerInfo;
    }

    @Override
    public String getYLcontractState(String cid) throws IOException{
        String yLcontractInfo = null;
       yLcontractentry = yLcontractentryService.getYLcontractentry(cid);
       String yLcontractentryState = yLcontractentry.getState();
       if( yLcontractentryState.equals("CUSTOMERAFFIRM") ){
           yLcontractInfo ="客户查看确认协议数据中";
       }else if(yLcontractentryState.equals("SALEMANFILLING")){
            yLcontractInfo = "业务员填写中";
       }else if(yLcontractentryState.equals("SALEMANMODIFYING")){
           yLcontractInfo = "业务员修改中";
       }else if(yLcontractentryState.equals("DEP_MARKET_CHECK")){
           yLcontractInfo = "市场部审核中";
       }else if(yLcontractentryState.equals("CSA_CHECK")){
           yLcontractInfo = "销售副总批准中";
       }else if(yLcontractentryState.equals("APPROVED")){
            yLcontractInfo = "协议书通过";
       }else{
           yLcontractInfo = "暂无最新消息";
       }
       return yLcontractInfo;
    }
}
