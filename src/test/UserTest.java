import com.yulan.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {

    @Test
    public void test1() {
//        DecimalFormat df = new DecimalFormat("0");
//        NumToChinese numToChinese = new NumToChinese();
//        System.out.println(numToChinese.transfrom(df.format(10000000000.00)));
       /* SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));*/
       String test="2019-1-17 16:02  郭远飞提交;2019-1-17 16:04  湖南小全家居商贸有限公司退回协议书，原因是 [tuhu];2019-1-17 16:06  郭远飞重新提交;2019-1-17 16:07  湖南小全家居商贸有限公司通过协议文本;2019-01-17 16:07  被中心总经理袁海亮 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;2019-01-17 16:10  被#DEP_MARKET_CHECK#肖伟#DEP_MARKET_CHECK# 审核批准协议文本;";

       System.out.println(StringUtil.getName(test,"#DEP_MARKET_CHECK#(.*?)#DEP_MARKET_CHECK#","#DEP_MARKET_CHECK#"));


    }
}

