package com.yulan.service.impl;

import com.yulan.dao.CustomerInfoDao;
import com.yulan.dao.YLcontractentryDao;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLc_info;
import com.yulan.service.YLc_infoService;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class YLc_infoServiceImpl implements YLc_infoService {
    @Autowired
    private CustomerInfoDao customerInfoDao;
    @Autowired
    private YLcontractentryDao yLcontractentryDao;

    @Override
    public Map getAllYLc_info(Integer start, Integer number, String year, String info_state, String ylc_state, String find) throws UnsupportedEncodingException {

        Map map=new HashMap<String,Object>(2);
        int count=customerInfoDao.countInfo(year,info_state,find);
        List<YLc_info> datas=new ArrayList<>();
        List<CustomerInfoCard> list=customerInfoDao.getAllinfo(start,number,year,info_state,find);
        for(CustomerInfoCard c:list){

            YLc_info yLc_info=new YLc_info();
            yLc_info.setCustomerId(c.getCid());
            yLc_info.setCustomerName(StringUtil.getUtf8(c.getCname()));
            yLc_info.setCardState(c.getState());
            if (c.getFile1Idcard()==null){
                yLc_info.setFile_1_idcard(0);
            }else{
                yLc_info.setFile_1_idcard(1);
            }

            if (c.getFile2Businesslicense()==null){
                yLc_info.setFile_2_businesslicense(0);
            }else{
                yLc_info.setFile_2_businesslicense(1);
            }

            if (c.getFile3Orgcode()==null){
                yLc_info.setFile_3_orgcode(0);
            }else{
                yLc_info.setFile_3_orgcode(1);
            }

            if (c.getFile4Gtqc()==null){
                yLc_info.setFile_4_gtqc(0);
            }else{
                yLc_info.setFile_4_gtqc(1);
            }

            yLc_info.setTx_agent_name(StringUtil.getUtf8(c.getTxAgentName()));
            yLc_info.setX_juridic_person(StringUtil.getUtf8(c.getxJuridicPerson()));
            yLc_info.setJuridic_person_handset(c.getJuridicPersonHandset());
            yLc_info.setMarketName(StringUtil.getUtf8(c.getMarketname()));
            yLc_info.setMarketManagerName(StringUtil.getUtf8(c.getMarketmanagername()));
            String ylcState=yLcontractentryDao.getState(c.getCid(),(int)c.getContractyear(),ylc_state);
            if(ylcState==null){
                String cid=c.getCid();
                continue;
            }else{
                yLc_info.setYlcState(ylcState);
                datas.add(yLc_info);
            }


        }


        map.put("data",datas);
        map.put("count",count);
        return map;
    }

    @Override
    public Map getAllinfo(Integer start, Integer number, String year, String info_state, String find,String cid) throws UnsupportedEncodingException {
        Map map=new HashMap<String,Object>(2);
        int count=customerInfoDao.countInfo(year,info_state,find);
        List<YLc_info> datas=new ArrayList<>();
        List<Map<String,Object>> areas=customerInfoDao.getAllArea(cid);
        List<CustomerInfoCard> list=customerInfoDao.getAllinfo(start,number,year,info_state,find);
        for(CustomerInfoCard c:list){

            for (Map m:areas){

                if (m.get("AREA_CODE").equals(c.getMarket())){
                    YLc_info yLc_info=new YLc_info();
                    yLc_info.setCustomerId(c.getCid());
                    yLc_info.setCustomerName(StringUtil.getUtf8(c.getCname()));
                    yLc_info.setCardState(c.getState());
                    if (c.getFile1Idcard()==null){
                        yLc_info.setFile_1_idcard(0);
                    }else{
                        yLc_info.setFile_1_idcard(1);
                    }

                    if (c.getFile2Businesslicense()==null){
                        yLc_info.setFile_2_businesslicense(0);
                    }else{
                        yLc_info.setFile_2_businesslicense(1);
                    }

                    if (c.getFile3Orgcode()==null){
                        yLc_info.setFile_3_orgcode(0);
                    }else{
                        yLc_info.setFile_3_orgcode(1);
                    }

                    if (c.getFile4Gtqc()==null){
                        yLc_info.setFile_4_gtqc(0);
                    }else{
                        yLc_info.setFile_4_gtqc(1);
                    }

                    yLc_info.setTx_agent_name(StringUtil.getUtf8(c.getTxAgentName()));
                    yLc_info.setX_juridic_person(StringUtil.getUtf8(c.getxJuridicPerson()));
                    yLc_info.setJuridic_person_handset(c.getJuridicPersonHandset());
                    yLc_info.setMarketName(StringUtil.getUtf8(c.getMarketname()));
                    yLc_info.setMarketManagerName(StringUtil.getUtf8(c.getMarketmanagername()));


                    datas.add(yLc_info);
                }

            }


        }

        map.put("data",datas);
        map.put("count",count);
        return map;
    }

    @Override
    public Map getInfoandylc(String find, String year, String infoStat, String ylcState) throws UnsupportedEncodingException {
        Map map=new HashMap<String,Object>(2);
        List<Map<String,Object>> list=customerInfoDao.getInfoandYlc(find,year,infoStat,ylcState);
        for(Map m:list){
            m.put("CNAME",StringUtil.getUtf8(m.get("CNAME").toString()));
            m.put("X_JURIDIC_PERSON",StringUtil.getUtf8(m.get("X_JURIDIC_PERSON").toString()));//法人
            m.put("TX_AGENT_NAME",StringUtil.getUtf8(m.get("TX_AGENT_NAME").toString()));//联系人
            m.put("SUBMARKETNAME",StringUtil.getUtf8(m.get("SUBMARKETNAME").toString()));//片区
            m.put("SUBMARKETMANAGERNAME",StringUtil.getUtf8(m.get("SUBMARKETMANAGERNAME").toString()));//片区负责人

        }

        return null;
    }

    public String getStateName(String state){
        String name="";
        switch (state){
            case "ONCREATE":
                name="初始状态";

                break;
            case "CUSTOMERPORCESSING":
                name="客户填写中";

                break;
            case "CUSTOMERPORCESSING2":
                name="客户修改中";

                break;
            case "BUSINESSCHECKING":
                name="业务员审核中";

                break;
            case "APPROVED":
                name="已通过";

                break;
            case "BIILDEPCHECKING":
                name="订单部审核";

                break;

            case "CUSTOMERAFFIRM":
                name="客户查看确认中";

                break;
            case "CSA_CHECK":
                name="销售副总批准中";

                break;
            case "DEP_MARKET_CHECK":
                name="市场部审核中";

                break;
            case "SALEMANFILLING":
                name="业务员填写中";

                break;
            case "ASM_CHECKING":
                name="销售中心经理审核中";

                break;
            default:break;
        }
        return name;
    }
}
