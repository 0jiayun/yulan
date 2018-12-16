import com.yulan.dao.WebcontractwfmemberDao;
import com.yulan.service.WebcontractwfmemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WebcontractwfmemberTest {
    @Autowired
    private WebcontractwfmemberDao webcontractwfmemberDao;
    @Autowired
    private WebcontractwfmemberService webcontractwfmemberService;

    @Test
    public void test2() throws UnsupportedEncodingException {

    }
}
