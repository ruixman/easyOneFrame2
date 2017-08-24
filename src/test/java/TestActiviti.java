import com.hfzs.framework.core.web.Application;
//import org.activiti.engine.RuntimeService;
import org.activiti.engine.RuntimeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/8/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestActiviti {
    @Autowired
    RuntimeService runtimeService;

//    @Test

    @Test
    public void contextLoads() {
        long count = runtimeService.createProcessInstanceQuery()
                .count();
        System.out.println(count);
        Assert.assertEquals(count,0);
    }
//
//    作者：会灰的大飞狼
//    链接：http://www.jianshu.com/p/6c9882693f35
//    來源：简书
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
