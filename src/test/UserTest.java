import com.yulan.dao.AreaRegionDao;
import com.yulan.dao.CustomerInfoDao;
import com.yulan.dao.UserDao;
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

    private CustomerInfoCard customerInfoCard;

    private MapUtils mapUtils;

    private StringUtil stringUtil;

    @Autowired
    private YLcontractentryService yLcontractentryService;

    private YLcontractentry yLcontractentry;

    @Test
    public void test1() throws Exception{
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

    }

}
