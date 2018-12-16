import com.yulan.dao.CustomerinfocardgroupDao;
import com.yulan.pojo.Customerinfocardgroup;
import com.yulan.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CustomerinfocardgroupTest {
    @Autowired
    private CustomerinfocardgroupDao customerinfocardgroupDao;

    @Test
    public void test1() throws UnsupportedEncodingException {

        List<Customerinfocardgroup> list=customerinfocardgroupDao.getCustomerinfocardgroups(1,10, StringUtil.setUtf8("2017年"),0);
        for (Customerinfocardgroup c:list){
            System.out.println(c.getDescp());
        }
    }
}
