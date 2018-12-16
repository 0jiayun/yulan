package com.yulan.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface YLc_infoService {
    Map getAllYLc_info(Integer start, Integer number, String year,
                       String info_state,String ylc_state,String find) throws UnsupportedEncodingException;

    Map getAllinfo(Integer start, Integer number, String year,
                   String info_state,String find,String cid) throws UnsupportedEncodingException;
}
