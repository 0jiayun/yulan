package com.yulan.service;

import java.io.IOException;
import java.util.Map;

public interface InfoStateService {

    Map getCustomerInfoCardState(String cid)throws IOException;

    Map getYLcontractState(String cid)throws IOException;

    boolean businessCheckCustomerInfoCard(String cid, String state, String memo)throws IOException;

    boolean lawCheckCustomerInfoCardState(String cid, String state, String memo,Integer legalchecked)throws IOException;

    boolean lawCheckYLcontractentryState(String cid, String state, String wfmemo,Integer signed,Integer legalchecked)throws IOException;

    boolean checkYLcontractentryState(String cid, String state, String wfmemo,Integer signed)throws IOException;
}
