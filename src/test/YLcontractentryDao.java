import com.yulan.service.YLcontractentryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class YLcontractentryDao {
    @Autowired
    private YLcontractentryService yLcontractentryService;

    @Test
    public void test1() {
        System.out.println(yLcontractentryService.showStateEchartYCl("2018").get("y"));
    }

    @Test
    public void test2() throws UnsupportedEncodingException {
        System.out.println(yLcontractentryService.getYClbyStateandCID(1,10,"2018").get("count"));
    }

}
