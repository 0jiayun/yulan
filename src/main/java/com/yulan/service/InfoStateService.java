package com.yulan.service;

import java.io.IOException;
import java.util.Map;

public interface InfoStateService {

    Map getCustomerInfoCardState(String cid)throws IOException;

    Map getYLcontractState(String cid)throws IOException;
}
