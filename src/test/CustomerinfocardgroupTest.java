import com.yulan.dao.CustomerDao;
import com.yulan.dao.CustomerInfoCardDao;
import com.yulan.dao.YLcontractentryDao;
import com.yulan.pojo.Customer;
import com.yulan.pojo.CustomerInfoCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CustomerinfocardgroupTest {
    @Autowired private CustomerDao customerDao;
    @Autowired private CustomerInfoCardDao customerInfoCardDao;
    @Autowired
    private YLcontractentryDao yLcontractentryDao;
    @Test
    public void test5(){
        System.out.println(yLcontractentryDao.getYLcontractentry("00294"));
//        List<Map<String,Object>> list=yLcontractentryDao.getAllYs(1,10,1,"00294",2018,"","","");
//        for (Map<String,Object> m:list){
//            System.out.println(m.get("AREA_NAME"));
//        }
    }

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
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Customer customer = new Customer();
        Class cl = customer.getClass();
//        Method[] methods = cl.getMethods();
//        for (Method method:methods) {
//            System.out.println(method.getReturnType()+":"+method.getName());
//        }
        Field[] fields = cl.getDeclaredFields();
        for (Field field:fields) {
            if (field.getType().toString().equals("class java.lang.String")) {
                Method method = cl.getDeclaredMethod("set"+toUpper(field.getName()));
                System.out.println(cl.getMethod("get"+toUpper(field.getName())).invoke(null));
                method.invoke(cl.getMethod("get"+toUpper(field.getName())).invoke(null));
            }
        }
    }
    private String toUpper(String origin) {
        return Character.toUpperCase(origin.charAt(0)) + origin.substring(1);
    }
}
