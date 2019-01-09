import com.yulan.dao.*;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.pojo.YLcontractentry;
import com.yulan.service.CustomerInfoService;
import com.yulan.service.InfoStateService;
import com.yulan.service.YLcontractentryService;
import com.yulan.utils.MapUtils;
import com.yulan.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CustomerInfoDao customerInfoDao;
    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private AreaRegionDao areaRegionDao;
    @Autowired
    private InfoStateService infoStateService;
    @Autowired
    private YLcontractentryDao yLcontractentryDao;

    private CustomerInfoCard customerInfoCard;

    private MapUtils mapUtils;

    private StringUtil stringUtil;

    @Autowired
    private YLcontractentryService yLcontractentryService;

    private YLcontractentry yLcontractentry;

    @Autowired
    private Web_userDao web_userDao;

    @Test
    public  void test() throws UnsupportedEncodingException {
        String position=web_userDao.getPosition("00039",2018);
        if (position!=null){
            System.out.println(position);
        }else {
            System.out.println("null");
        }
    }

    @Test
    public  void test0() throws UnsupportedEncodingException {
        List<Map<String,Object>> list=web_userDao.getArea_position("00934");
        for (Map<String,Object> map:list){
            System.out.println(StringUtil.getUtf8(map.get("POSITION").toString()));
        }
    }

    @Test
    public void test1() throws Exception {
        /*List<Map<String,Object>> list=customerInfoDao.getAllArea("00294");
        for (Map m:list){
            System.out.println(m.get("AREA_CODE"));
        }*/
        /*List<AreaRegion> list = areaRegionDao.getProvince();
        for(AreaRegion a : list){
            System.out.println(stringUtil.getUtf8(a.getRegionName()));
        }*/
       /* String yLcontractInfo = null;
        yLcontractentry = yLcontractentryService.getYLcontractentry("C15056");
        String yLcontractentryMemo = yLcontractentry.getWfmemo();
        Document doc = Jsoup.parse(yLcontractentryMemo);
        List<String> list = new ArrayList<>();
        for (String retval: doc.text().split(";")){
            list.add(retval);
        }
        List<String> list2 = stringUtil.replaceState(list,"#CSA_CHECK#","法务员");
        for (String l: list2){
            System.out.println(l);
        }*/
        /*Map<String,Object> map = infoStateService.getYLcontractState("C15056");
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }*/
        // System.out.println(customerInfoDao.businessCheckCustomerInfoCard("C15093","1234","4321"));
      /* List<AreaUser> map = areaRegionDao.getAreaUserCode("DRP0054");
       List<String> list2 = new ArrayList<>();
        for (AreaUser list : map) {
            System.out.println(list.getAreaCode());
            list2.add(list.getAreaCode());
        }
        List<AreaCode> list = areaRegionDao.getAreaCodeName(list2 );
        for (AreaCode l : list) {
            System.out.println(l);
        }*/
       /* List<Map<String, Object>> list = customerInfoDao.getAllCustomerInfoCardArea("2018");
        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                entry.setValue(origin);
                List<Map<String, Object>> list2 = customerInfoDao.getCustomerInfoCardStateByArea("2018",(String)entry.getValue());
                for (Map<String, Object> m : list2) {
                    System.out.println(m);
                }
            }
        }*/
       List<Map<String, Object>> list2 = yLcontractentryDao.getYLcontractentryStateByArea("2018");
        for (Map<String, Object> map : list2) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String origin = stringUtil.getUtf8(String.valueOf(entry.getValue()));
                entry.setValue(origin);
            }
            System.out.println(map);
        }
    }
}

