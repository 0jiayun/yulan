package com.yulan.service;

import java.io.IOException;

public interface InfoStateService {

    String getCustomerInfoCardState(String cid)throws IOException;

    String getYLcontractState(String cid)throws IOException;
}
