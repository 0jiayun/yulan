import com.yulan.dao.CustomerInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CustomerInfocardTest {
    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Test
    public void test1() throws UnsupportedEncodingException {
//        List<Map<String, Object>> list=customerInfoDao.getInfobyStateandmarketName();
//        for (Map m:list){
//            System.out.println(m.get("STATE"));
//
//        }



    }
}
