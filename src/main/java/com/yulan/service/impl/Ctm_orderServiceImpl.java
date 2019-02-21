package com.yulan.service.impl;

import com.yulan.dao.Ctm_orderDao;
import com.yulan.service.Ctm_orderService;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Ctm_orderServiceImpl implements Ctm_orderService {
    @Autowired
    private Ctm_orderDao ctm_orderDao;


    @Override
    public Map getOrders(Integer start, Integer number, String cid, String state_id, String find) throws UnsupportedEncodingException {
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> list=ctm_orderDao.getOrders(start,number,cid,state_id,find);
        for (Map<String,Object> m:list) {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                if (entry.getValue() instanceof String) {
                    String origin = StringUtil.getUtf8(String.valueOf(entry.getValue()));
                    entry.setValue(origin);
                }
            }

        }
        map.put("data",list);
        map.put("count",ctm_orderDao.countOrders(cid,state_id,find));
        return map;
    }
}
