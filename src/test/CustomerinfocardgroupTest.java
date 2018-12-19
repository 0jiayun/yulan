import com.yulan.dao.CustomerDao;
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
public class CustomerinfocardgroupTest {
    @Autowired private CustomerDao customerDao;
    @Autowired private CustomerInfoCardDao customerInfoCardDao;
    @Test
    public void test1() {
        List<CustomerInfoCard> customerInfoCards = new ArrayList<>();
        CustomerInfoCard customerInfoCard = new CustomerInfoCard();
        customerInfoCard.setGroupid("1");
        CustomerInfoCard customerInfoCard1 = new CustomerInfoCard();
        customerInfoCard1.setGroupid("2");
        customerInfoCards.add(customerInfoCard);
        customerInfoCards.add(customerInfoCard1);
        System.out.println(customerInfoCardDao.addCustomerInfoCard(customerInfoCard));
    }
}
