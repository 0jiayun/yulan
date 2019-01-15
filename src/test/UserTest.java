import com.yulan.dao.CustomerInfoCardDao;
import com.yulan.pojo.CustomerInfoCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    private CustomerInfoCardDao customerInfoCardDao;
    @Test
    public void test1() {
        List<CustomerInfoCard> customerInfoCards = new ArrayList<>();
        CustomerInfoCard customerInfoCard = new CustomerInfoCard();
        customerInfoCard.setGroupid("3078e1a17ffa40cfb81cf42da0f4ce23");
        customerInfoCard.setCid("FNR002");
        customerInfoCards.add(customerInfoCard);
        CustomerInfoCard customerInfoCard1 = new CustomerInfoCard();
        customerInfoCard1.setGroupid("3078e1a17ffa40cfb81cf42da0f4ce23");
        customerInfoCard1.setCid("FNR006");
        customerInfoCards.add(customerInfoCard1);
//        customerInfoCardDao.addCustomerInfoCards(customerInfoCards);
    }
}

