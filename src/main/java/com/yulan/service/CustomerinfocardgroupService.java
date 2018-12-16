package com.yulan.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface CustomerinfocardgroupService {
    //获取所有
    Map getCustomerinfocardgroups(Integer start,Integer number,String descp,int deleted) throws UnsupportedEncodingException;


    //标记删除
    int updateDelete(String Id);
}
