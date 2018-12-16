import com.yulan.dao.Web_userDao;
import com.yulan.utils.PasswordUtil;
import com.yulan.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PasswordTest {
    @Autowired
    private Web_userDao web_userDao;

    @Test
    public void test1() throws UnsupportedEncodingException {
        System.out.println(StringUtil.getUtf8(web_userDao.check("admin")));
        System.out.println("yulan1234:"+PasswordUtil.stringEncrypter("yulan1234",true));

        System.out.println(web_userDao.check("D0020"));
        System.out.println("1234:"+PasswordUtil.stringEncrypter("1234"));



    }
}
