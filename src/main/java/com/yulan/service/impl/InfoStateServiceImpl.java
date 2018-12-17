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
        customerInfoCard = customerInfoService.getCustomerInfo(cid);
        String customerInfoCardState = customerInfoCard.getState();
        if(customerInfoCardState == null || customerInfoCardState.equals("")){
            return null;
        }else{
            return customerInfoCardState;
        }
    }

    @Override
    public String getYLcontractState(String cid) throws IOException{
       yLcontractentry = yLcontractentryService.getYLcontractentry(cid);
       String yLcontractentryState = yLcontractentry.getState();
       if( yLcontractentryState == null||yLcontractentryState.equals(("")) ){
           return null;
       }else{
           return yLcontractentryState;
       }
    }
}
