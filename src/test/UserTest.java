import com.yulan.dao.CustomerInfoDao;
import com.yulan.dao.UserDao;
import com.yulan.pojo.CustomerInfoCard;
import com.yulan.service.CustomerInfoService;
import com.yulan.utils.MapUtils;
import com.yulan.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    private CustomerInfoCard customerInfoCard;

    private MapUtils mapUtils;

    private StringUtil stringUtil;

    @Test
    public void test1() throws Exception{
        List<Map<String,Object>> list=customerInfoDao.getAllArea("00294");
        for (Map m:list){
            System.out.println(m.get("AREA_CODE"));
        }
    }

}
