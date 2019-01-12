import com.yulan.pojo.User;
import com.yulan.utils.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Test
    public void test1() {
        Map<String,Object> object = new HashMap<>();
        User user = new User();
        user.setCustomerId("aaa");
        user.setCustomerName("bbb");
        object.put("user",user);
        String token = Token.createToken(object,null);
//        System.out.println(token);
        System.out.println(Token.parseToken(token));
    }
}

