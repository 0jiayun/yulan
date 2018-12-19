package com.yulan.service.impl;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontractentry;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.InfoStateService;
import com.yulan.service.YLcontractentryService;
import com.yulan.utils.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfoStateServiceImpl implements InfoStateService {
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private YLcontractentryService yLcontractentryService;

    private YLcontractentry yLcontractentry;

    private CustomerInfoCard customerInfoCard;

    private StringUtil stringUtil;

    @Override
    public Map getCustomerInfoCardState(String cid) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String customerInfo = null;
        customerInfoCard = customerInfoService.getCustomerInfo(cid);
        String customerInfoCardState = customerInfoCard.getState();
        String memo = customerInfoCard.getMemo();

        List<String> memoReplaced = new ArrayList<>();
        //将原先数据库中的html解析
        Document doc = Jsoup.parse(memo);
        for (String retval: doc.text().split(";")){
            memoReplaced.add(retval);
        }
        //转换原先审核记录中的特殊字段，可能还有其他的，以后再加
       /* Map<String,Object> state = new HashMap();
        state.put("销售副总","#CSA_CHECK#");
        state.put("市场部","#DEP_MARKET_CHECK#");
        state.put("销售中心经理","#ASM_CHECKING#");

        for (Map.Entry<String,Object> entry : state.entrySet()) {
            memoReplaced = stringUtil.replaceState(memoReplaced,(String)entry.getValue(),entry.getKey());
        }*/


        if(customerInfoCardState.equals("CUSTOMERPORCESSING2")){
            customerInfo = "资料卡被退回请重新填写";
        }else if(customerInfoCardState.equals("BUSINESSCHECKING")){
            customerInfo = "业务员审核中";
        }else if(customerInfoCardState.equals("APPROVED")){
            customerInfo = "资料卡通过";
        }else{
            customerInfo = "暂无最新消息";
        }
        map.put("customerInfo",customerInfo);
        map.put("memo",memoReplaced);
        return map;
    }

    @Override
    public Map getYLcontractState(String cid) throws IOException{
        Map<String,Object> map = new HashMap<>();
        String yLcontractInfo = null;


       yLcontractentry = yLcontractentryService.getYLcontractentry(cid);
       String yLcontractentryState = yLcontractentry.getState();
       String yLcontractentryMemo = yLcontractentry.getWfmemo();
        List<String> memoReplaced = new ArrayList<>();
        //将原先数据库中的html解析
        Document doc = Jsoup.parse(yLcontractentryMemo);
        for (String retval: doc.text().split(";")){
            memoReplaced.add(retval);
        }
        //转换原先审核记录中的特殊字段，可能还有其他的，以后再加
        Map<String,Object> state = new HashMap();
        state.put("销售副总","#CSA_CHECK#");
        state.put("市场部","#DEP_MARKET_CHECK#");
        state.put("销售中心经理","#ASM_CHECKING#");

        for (Map.Entry<String,Object> entry : state.entrySet()) {
            memoReplaced = stringUtil.replaceState(memoReplaced,(String)entry.getValue(),entry.getKey());
        }

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
       map.put("yLcontractInfo",yLcontractInfo);
       map.put("yLcontractentryMemo",memoReplaced);
       return map;
    }
}
