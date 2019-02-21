import com.yulan.dao.Ctm_orderDao;
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
    private Ctm_orderDao ctm_orderDao;

    @Test
    public void test1() throws UnsupportedEncodingException {
        List<Map<String,Object>> list=ctm_orderDao.getOrders(1,10,"C10110",null,null);
        for (Map<String,Object> m:list){
            System.out.println(m.get("ORDER_NO"));
        }
//       System.out.println(ctm_orderDao.countOrders("C10110",null,null));

    }

}

