import com.yulan.utils.NumToChinese;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    @Test
    public void test1() {
        NumToChinese numToChinese = new NumToChinese();
        System.out.println(numToChinese.transfrom("50000000"));
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));*/
    }
}

