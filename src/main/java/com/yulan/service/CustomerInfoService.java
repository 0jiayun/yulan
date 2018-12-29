package com.yulan.service;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontract_v2015_paa;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface CustomerInfoService {

    CustomerInfoCard getCustomerInfo(String cID)throws IOException;

    Map<String, Object> showStateEchart(String year);

    Map getInfobyStateandmarketName(Integer start,Integer number,String year) throws UnsupportedEncodingException;

    List<Map<String,Object>> getAllStates();


    //获取委托书
    YLcontract_v2015_paa getYLcontract(String cCID) throws IOException;

    //   boolean customer(String cID);
    // 更新客户资料卡
    boolean updateCustomerInfo(CustomerInfoCard customerInfoCard)throws IOException;

    boolean createYLcontract(YLcontract_v2015_paa yLcontract_v2015_paa) throws IOException;

    String getXAreaDistrictName(String getXAreaDistrict3Name)throws IOException;

    String getXDistrict(String xDistrict)throws IOException;

    List<Map> getAllStatisticsInfo(String userCID,String userCName,String managerCID);

    List<Map<String,Object>> getAllCustomerInfoCardState(String year);

    List<Map<String,Object>> getCustomerInfoCardStateByArea(String year)throws IOException;


}
