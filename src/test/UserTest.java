import com.yulan.dao.Area_ownerDao;
import com.yulan.dao.CustomerInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
    @Autowired
    private Area_ownerDao area_ownerDao;
    private CustomerInfoDao customerInfoDao;
    @Test
    public void test1() {
        System.out.println(area_ownerDao.getAreaOwnerByAreaCode("C047"));
    }

    @Test
    public void test2(){

    }
}

