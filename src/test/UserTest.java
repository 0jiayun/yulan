import com.yulan.utils.NumToChinese;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DecimalFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    @Test
    public void test1() {
        DecimalFormat df = new DecimalFormat("0");
        NumToChinese numToChinese = new NumToChinese();
        System.out.println(numToChinese.transfrom(df.format(10000000000.00)));
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));*/
    }
}

