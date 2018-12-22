package com.yulan.service.impl;

import com.yulan.dao.CustomerInfoDao;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontract_v2015_paa;
import com.yulan.service.CustomerInfoService;
import com.yulan.utils.MapUtils;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
    @Autowired

    private CustomerInfoDao customerInfoDao;

    private CustomerInfoCard customerInfoCard;

    private YLcontract_v2015_paa yLcontract_v2015_paa;

    private StringUtil stringUtil;

    private static MapUtils mapUtils;









    @Override
    public List<Map<String,Object>> getAllStates() {
        List<Map<String,Object>> list=customerInfoDao.getAllStates();
        List<Map<String,Object>> states=new ArrayList<>();
        for (Map m:list){
            if(m==null||m.get("STATE").equals("1234")){
                continue;
            }
            Map<String,Object> map=new HashMap<>();
            map.put("id",m.get("STATE"));

            switch (m.get("STATE").toString()){
                case "ONCREATE":
                    map.put("name","初始状态");
                    break;
                case "CUSTOMERPORCESSING":

                    map.put("name","客户填写中");
                    break;
                case "CUSTOMERPORCESSING2":

                    map.put("name","客户修改中");
                    break;
                case "BUSINESSCHECKING":

                    map.put("name","业务员审核中");
                    break;
                case "APPROVED":

                    map.put("name","已通过");
                    break;
                case "BIILDEPCHECKING":

                    map.put("name","订单部审核");
                    break;
                default:break;
            }
            states.add(map);
        }
        return states;
    }
    @Override
    public CustomerInfoCard getCustomerInfo(String cID) throws IOException {
        if(customerInfoDao.getCustomerInfo(cID) == null){
            return null;
        }else{
            customerInfoCard = customerInfoDao.getCustomerInfo(cID);
            Map<String, Object> map = new HashMap<String, Object>();
            map = mapUtils.beanToMap(customerInfoCard);

            for (Map.Entry<String,Object> entry : map.entrySet()) {
                if(entry.getValue() instanceof String){
                    String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                    entry.setValue(origin);
                }
            }
            return mapUtils.mapToBean(map,CustomerInfoCard.class);
        }

    }

    @Override
    public YLcontract_v2015_paa getYLcontract(String cCID) throws  IOException{
        if(customerInfoDao.getYLcontract(cCID)== null){
            return null;
        }else{
            yLcontract_v2015_paa = customerInfoDao.getYLcontract(cCID);
            Map<String, Object> map = new HashMap<String, Object>();
            map = mapUtils.beanToMap(yLcontract_v2015_paa);

            for (Map.Entry<String,Object> entry : map.entrySet()) {
                if(entry.getValue() instanceof String){
                    String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                    entry.setValue(origin);
                }
            }
            return mapUtils.mapToBean(map,YLcontract_v2015_paa.class);
        }
    }

    @Override
    public boolean updateCustomerInfo(CustomerInfoCard customerInfoCard) throws IOException{
        Map<String, Object> map = new HashMap<String, Object>();
        map = mapUtils.beanToMap(customerInfoCard);

        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if(entry.getValue() instanceof String){
                String origin = stringUtil.setUtf8(String.valueOf(entry.getValue()));
                entry.setValue(origin);
            }

        }

        customerInfoCard = mapUtils.mapToBean(map,CustomerInfoCard.class);

        return customerInfoDao.updateCustomerInfo(customerInfoCard);
    }

    @Override
    public boolean createYLcontract(YLcontract_v2015_paa yLcontract_v2015_paa) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map = mapUtils.beanToMap(yLcontract_v2015_paa);

        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if(entry.getValue() instanceof String){
                String origin = stringUtil.setUtf8(String.valueOf(entry.getValue()));
                entry.setValue(origin);
            }
        }

        yLcontract_v2015_paa = mapUtils.mapToBean(map,YLcontract_v2015_paa.class);
        return customerInfoDao.insertYLcontract(yLcontract_v2015_paa);
    }

    @Override
    public String getXDistrict(String xDistrict) throws IOException {
        if(customerInfoDao.getXDistrict(xDistrict).equals("") || customerInfoDao.getXDistrict(xDistrict) == null){
            return null;
        }else{
            xDistrict = stringUtil.getUtf8(customerInfoDao.getXDistrict(xDistrict));
            return xDistrict;
        }
    }

    @Override
    public String getXAreaDistrictName(String getXAreaDistrict3Name) throws IOException {
        if(customerInfoDao.getXAreaDistrictName(getXAreaDistrict3Name).equals("") || customerInfoDao.getXAreaDistrictName(getXAreaDistrict3Name) == null){
            return null;
        }else{
            getXAreaDistrict3Name = stringUtil.getUtf8(customerInfoDao.getXAreaDistrictName(getXAreaDistrict3Name));
            return getXAreaDistrict3Name;
        }
    }

    @Override
    public Map<String, Object> showStateEchart(String year) {
        String Y="全部年份";
        if (year!=null){
            Y=year;
        }
        List x=new ArrayList();
        List y=new ArrayList();
        Map<String,Object> map=new HashMap<>();
        List<Map> list=customerInfoDao.getInfoBySate(year);
        for(Map m:list){
            switch (m.get("STATE").toString()){
                case "ONCREATE":
                    y.add("初始状态");
                    x.add(m.get("NUMS"));
                    break;
                case "CUSTOMERPORCESSING":
                    y.add("客户填写中");
                    x.add(m.get("NUMS"));
                    break;
                case "CUSTOMERPORCESSING2":
                    y.add("客户修改中");
                    x.add(m.get("NUMS"));
                    break;
                case "BUSINESSCHECKING":
                    y.add("业务员审核中");
                    x.add(m.get("NUMS"));
                    break;
                case "APPROVED":
                    y.add("已通过");
                    x.add(m.get("NUMS"));
                    break;
                case "BIILDEPCHECKING":
                    y.add("订单部审核");
                    x.add(m.get("NUMS"));
                    break;
                default:break;
            }
        }
        map.put("textname",Y+"网签资料卡执行汇总");
        map.put("y",y);
        map.put("x",x);

        return map;
    }

    @Override
    public Map getInfobyStateandmarketName(Integer start, Integer number,String year) throws UnsupportedEncodingException {
        Map map=new HashMap<String,Object>(2);
        List<Map<String,Object>> list=customerInfoDao.getInfobyStateandmarketName(start,number,year);
        List<Map<String,Object>> list2=new ArrayList<>();
        for (Map<String,Object> m:list){
            if (m.get("MARKETNAME")!=null) {
                m.put("MARKETNAME", StringUtil.getUtf8(m.get("MARKETNAME").toString()));
            }
            if (m.get("SUBMARKETMANAGERNAME")!=null){
                m.put("SUBMARKETMANAGERNAME",StringUtil.getUtf8(m.get("SUBMARKETMANAGERNAME").toString()));
            }



            list2.add(m);
        }
        map.put("data",list2);
        map.put("count",customerInfoDao.count(year));
        return map;
    }

    @Override
    public List<Map> getAllStatisticsInfo(String userCID, String userCName, String managerCID) {
        List<Map> result = new ArrayList<>();
        List<Map<String,Object>> markets = customerInfoDao.getAllArea(managerCID);
        String[] statusNames = new String[]{"初始状态","客户填写中","客户修改中","业务员审核中","已通过","订单部审核"};
        long status[] = new long[6];
        for (int i=0;i<6;i++) {
            status[i] = 0;
        }
        for (Map<String,Object> market:markets) {
            List<Map<String,Object>> values = customerInfoDao.getAllStatisticsInfo((String) market.get("AREA_CODE"),userCID,userCName);
            for (Map<String,Object> value:values) {
                switch((String)value.get("STATE")) {
                    case "ONCREATE":status[0] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    case "CUSTOMERPORCESSING": status[1] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    case "CUSTOMERPORCESSING2":status[2] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    case "BUSINESSCHECKING":status[3] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    case "APPROVED":status[4] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    case "BIILDEPCHECKING":status[5] += ((BigDecimal)value.get("NUMS")).longValue();break;
                    default:continue;
                }
            }
        }
        for (int i=0;i<6;i++) {
            Map<String,Object> value = new HashMap<>();
            value.put("state",statusNames[i]);
            value.put("number",status[i]);
            result.add(value);
        }
        return result;
    }

}
