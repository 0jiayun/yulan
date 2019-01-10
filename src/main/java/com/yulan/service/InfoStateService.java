package com.yulan.service;

import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontractentry;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface InfoStateService {

    Map getCustomerInfoCardState(String cid)throws IOException;

    Map getYLcontractState(String cid,String cyear)throws IOException;

    boolean businessCheckCustomerInfoCard(String cid, String state, String memo)throws IOException;

    boolean lawCheckCustomerInfoCardState(String cid, String state, String memo,Integer legalchecked)throws IOException;

    boolean lawCheckYLcontractentryState(String cid, String state, String wfmemo,Integer signed,Integer legalchecked)throws IOException;

    boolean checkYLcontractentryState(String cid, String state, String wfmemo,Integer signed)throws IOException;

    List<CustomerInfoCard> getCustomerInfoCardLeagalChecked(Integer start,Integer number,Integer legalChecked)throws IOException;

    List<YLcontractentry> getYLcontractentryLeagalChecked(Integer start, Integer number, Integer legalChecked)throws IOException;
}
