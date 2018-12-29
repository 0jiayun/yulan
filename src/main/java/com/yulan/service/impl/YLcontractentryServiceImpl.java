package com.yulan.service.impl;

import com.yulan.dao.YLcontractentryDao;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontract_v2015;
import com.yulan.pojo.YLcontractentry;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.YLcontractentryService;
import com.yulan.utils.MapUtils;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YLcontractentryServiceImpl implements YLcontractentryService {
    @Autowired
    private YLcontractentryDao yLcontractentryDao;

    private YLcontract_v2015 yLcontract_v2015;
    @Autowired
    private CustomerInfoService customerInfoService;

    private StringUtil stringUtil;

    private YLcontractentry yLcontractentry;

    private CustomerInfoCard customerInfoCard;

    private MapUtils mapUtils;

    @Override
    public Map<String, Object> showStateEchartYCl(String year) {
        String Y="全部年份";
        if (year!=null){
            Y=year;
        }
        List x=new ArrayList();
        List y=new ArrayList();
        Map<String,Object> map=new HashMap<>();
        List<Map> list=yLcontractentryDao.getYLcBySate(year);
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
                case "CUSTOMERAFFIRM":
                    y.add("客户查看确认中");
                    x.add(m.get("NUMS"));
                    break;
                case "CSA_CHECK":
                    y.add("销售副总批准中");
                    x.add(m.get("NUMS"));
                    break;
                case "DEP_MARKET_CHECK":
                    y.add("市场部审核中");
                    x.add(m.get("NUMS"));
                    break;
                case "SALEMANFILLING":
                    y.add("业务员填写中");
                    x.add(m.get("NUMS"));
                    break;
                case "ASM_CHECKING":
                    y.add("销售中心经理审核中");
                    x.add(m.get("NUMS"));
                    break;
                default:break;
            }
        }
        map.put("textname",Y+"协议网签执行汇总");
        map.put("y",y);
        map.put("x",x);

        return map;

    }

    @Override
    public Map getYClbyStateandCID(Integer start, Integer number,String year) throws UnsupportedEncodingException {
        Map map=new HashMap<String,Object>(2);
        List<Map<String,Object>> list=yLcontractentryDao.getYLcbyStateandCID(start,number,year);
        List<Map<String,Object>> list2=new ArrayList<>();
        for (Map<String,Object> m:list){
            String area_code=yLcontractentryDao.getArea_code(m.get("CID").toString());
            String area_name=yLcontractentryDao.getAreaName(area_code);
            m.put("MARKETNAME", StringUtil.getUtf8(area_name));
            String owner=yLcontractentryDao.getCenter_mangerId(area_code);
            String managerName=yLcontractentryDao.getName(owner);
            m.put("SUBMARKETMANAGERNAME",StringUtil.getUtf8(managerName));
            list2.add(m);
        }
        map.put("data",list2);
        map.put("count",yLcontractentryDao.count(year));

        return map;
    }

    @Override
    public List<Map<String, Object>> getAllStates() {
        List<Map<String,Object>> list=yLcontractentryDao.getAllStates();
        List<Map<String,Object>> states=new ArrayList<>();
        for (Map m:list){
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
                case "CUSTOMERAFFIRM":
                    map.put("name","客户查看确认中");
                    break;
                case "CSA_CHECK":
                    map.put("name","销售副总批准中");
                    break;
                case "DEP_MARKET_CHECK":
                    map.put("name","市场部审核中");
                    break;
                case "SALEMANFILLING":
                    map.put("name","业务员填写中");
                    break;
                case "ASM_CHECKING":
                    map.put("name","销售中心经理审核中");
                    break;
                default:break;
            }
            states.add(map);
        }
        return states;
    }

    @Override
    public YLcontract_v2015 getYLcontract_v2015(String ccid) throws IOException {
        if(yLcontractentryDao.getYLcontract_v2015(ccid) == null){
            return null;
        }else{
            yLcontract_v2015 = yLcontractentryDao.getYLcontract_v2015(ccid);
            String preferedbrand = stringUtil.getUtf8(yLcontract_v2015.getPreferedbrand());
            yLcontract_v2015.setPreferedbrand(preferedbrand);
            return yLcontract_v2015;
        }

    }

    @Override
    public boolean createYLcontract_v2015(YLcontract_v2015 yLcontract_v2015) throws IOException {
        yLcontract_v2015.setPreferedbrand(stringUtil.setUtf8(yLcontract_v2015.getPreferedbrand()));
        return yLcontractentryDao.createYLcontract_v2015(yLcontract_v2015);
    }

    @Override
    public String getYLcontractHTML(String cid) throws IOException {
        List<Object> list = new ArrayList<Object>();
        /*
        CustomerInfoCard
        cname
        X_POST_ADDRESS
        X_DISTRICT、X_AREA_DISTRICT_2、X_AREA_DISTRICT_3
        preferedbrand
        account1Name //公司开户名
        account2Name //个人开户名
        account1Bank //公司银行
        account2Name
        account1 银行账号
        account2
        account1Location
        account2Location
          */
        customerInfoCard = customerInfoService.getCustomerInfo(cid);
        /*
        YLCONTRACTENTRY
        startDate
        endDate
         */
        yLcontractentry = yLcontractentryDao.getYLcontractentry(cid);
        /*
        YLCONTRACT_V2015
        总任务 = 玉兰+尚居
        A_RETAILING 玉兰
        C_MATCHING 尚居
        M1
        M2
        M3
        M4
        M5
        M6
        M7
        M8
        M9
        M10
        M11
        M12
        TOTAL = M1+...+M12
        REWORDPERCENT 总返点比例
        REWORDPERCENT2兰居返点
        STOCKPERCENT备货比例
        人名币 = 总任务 * 备货比例
        PRIVATE_ACCOUNT_AUTHED 客户授权配偶账号
        */
        yLcontract_v2015 = getYLcontract_v2015(cid);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Double total = (yLcontract_v2015.getM1()+yLcontract_v2015.getM2()+yLcontract_v2015.getM3()+yLcontract_v2015.getM4()+yLcontract_v2015.getM5()
                +yLcontract_v2015.getM6()+yLcontract_v2015.getM7()+yLcontract_v2015.getM8()+yLcontract_v2015.getM9()
                +yLcontract_v2015.getM10()+yLcontract_v2015.getM11()+yLcontract_v2015.getM12());
        list.add(customerInfoCard.getCname());
        list.add(customerInfoCard.getxPostAddress());
        list.add(customerInfoService.getXDistrict(customerInfoCard.getxDistrict()));
        list.add(customerInfoService.getXAreaDistrictName(customerInfoCard.getxAreaDistrict2()));
        list.add(customerInfoService.getXAreaDistrictName(customerInfoCard.getxAreaDistrict3()));
        list.add(sdf.format(yLcontractentry.getStartDate()));
        list.add(sdf.format(yLcontractentry.getEndDate()));
        list.add(yLcontract_v2015.getPreferedbrand());
        list.add(Double.toString(yLcontract_v2015.getaRetailing() + yLcontract_v2015.getcMatching()));
        list.add(Double.toString(yLcontract_v2015.getaRetailing()));
        list.add(Double.toString(yLcontract_v2015.getcMatching()));
        list.add(Double.toString(yLcontract_v2015.getM1()));
        list.add(Double.toString(yLcontract_v2015.getM2()));
        list.add(Double.toString(yLcontract_v2015.getM3()));
        list.add(Double.toString(yLcontract_v2015.getM4()));
        list.add(Double.toString(yLcontract_v2015.getM5()));
        list.add(Double.toString(yLcontract_v2015.getM6()));
        list.add(Double.toString(yLcontract_v2015.getM7()));
        list.add(Double.toString(yLcontract_v2015.getM8()));
        list.add(Double.toString(yLcontract_v2015.getM9()));
        list.add(Double.toString(yLcontract_v2015.getM10()));
        list.add(Double.toString(yLcontract_v2015.getM11()));
        list.add(Double.toString(yLcontract_v2015.getM12()));
        list.add(Double.toString(total));
        list.add(Double.toString(yLcontract_v2015.getRewordpercent()));
        list.add(Double.toString(yLcontract_v2015.getRewordpercent2()));
        list.add(Double.toString(yLcontract_v2015.getStockpercent()));
        list.add(Double.toString(yLcontract_v2015.getStockpercent() * total));
        list.add(customerInfoCard.getAccount1Name());
        list.add(customerInfoCard.getAccount2Name());
        list.add(customerInfoCard.getAccount1Bank());
        list.add(customerInfoCard.getAccount2Bank());
        list.add(customerInfoCard.getAccount1());
        list.add(customerInfoCard.getAccount2());
        list.add(customerInfoCard.getAccount1Location());
        list.add(customerInfoCard.getAccount2Location());
        list.add(yLcontract_v2015.getPrivateAccountAuthed());

        String test = yLcontractentryDao.getYLcontractHTML(1).getTest();
        test = StringUtil.getUtf8(test);

        String html = stringUtil.replace(test,"AAAA",list);

        return html;
    }



    @Override
    public YLcontractentry getYLcontractentry(String cid) throws IOException {
        if(yLcontractentryDao.getYLcontractentry(cid) == null){
            return null;
        }else{
            yLcontractentry = yLcontractentryDao.getYLcontractentry(cid);
            Map<String, Object> map = new HashMap<String, Object>();
            map = mapUtils.beanToMap(yLcontractentry);

            for (Map.Entry<String,Object> entry : map.entrySet()) {
                if(entry.getValue() instanceof String){
                    String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                    entry.setValue(origin);
                }
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
            return mapUtils.mapToBean(map,YLcontractentry.class);
        }
    }

    @Override
        public Map getYlcsbySigned(Integer start, Integer number, Integer signed, Integer year, String cid,String area_1,
                                   String area_2,String find) throws UnsupportedEncodingException {
        Map<String,Object> map=new HashMap<>();
        List<Map<String,Object>> list=yLcontractentryDao.getAllYs(start,number,signed,cid,year,area_1,area_2,find);
        List<Map<String,Object>> data=new ArrayList<>();
        map.put("count",yLcontractentryDao.countYs(signed,cid,year,area_1,area_2,find));
        for (Map<String,Object> m:list) {
            for (Map.Entry<String, Object> entry : m.entrySet()) {
                if (entry.getValue() instanceof String) {
                    String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                    entry.setValue(origin);
                }
            }
            data.add(m);
        }
        map.put("data",data);

        return map;
    }

    @Override
    public List<Map<String, Object>> getAllYLcontractentryState(String year) {
        List<Map<String, Object>> list = yLcontractentryDao.getAllYLcontractentryState(year);
        return list;
    }

    /**
     * 协议书列表获取
     * @param start
     * @param number
     * @param signed
     * @return
     * @throws UnsupportedEncodingException
     */
    @Override
    public Map getAllYlcs(Integer start, Integer number, String signed,Integer year,String cid) throws UnsupportedEncodingException {
        Map<String,Object> map=new HashMap<>();
        int count =yLcontractentryDao.countYlcs(signed);
        List<YLcontractentry> list=yLcontractentryDao.getAllYlcs(start,number,signed);
        List<YLcontractentry> data=new ArrayList<>();
        for (YLcontractentry y:list){
            Map<String,Object> m= MapUtils.beanToMap(y);
            for (Map.Entry<String,Object> entry:m.entrySet()){
                String origin = stringUtil.setUtf8(String.valueOf(entry.getValue()));
                entry.setValue(origin);
            }
            y=MapUtils.mapToBean(m,YLcontractentry.class);
            data.add(y);
        }
        map.put("data",data);
        map.put("count",count);
        return map;
    }

}
