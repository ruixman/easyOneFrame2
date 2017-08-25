import com.hfzs.framework.core.web.Application;
//import org.activiti.engine.RuntimeService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;

/**
 * Created by Administrator on 2017/8/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestActiviti {
    @Autowired
    RuntimeService runtimeService;

    @Autowired
    RepositoryService repositoryService;

    private String filename = "D:\\idel_workspace\\zhishenframe\\src\\main\\resources\\processes\\MyProcess.bpmn";

    @Test
    //重新发布
    public void testDeploy() throws Exception{
        Deployment res = repositoryService.createDeployment().addInputStream("Process2_v1.2.bpmn",
                new FileInputStream(filename)).deploy();
        System.err.println("deploy MyProcess.bpmn:版本号 : "+res.getId());
    }
    @Test
    public void contextLoads() {
        long count = runtimeService.createProcessInstanceQuery().count();
        System.out.println(count);
        Assert.assertEquals(count,1);
    }

    @Test
    public void testProcess1(){
        String _bussinessKey="myProcess";
        ProcessInstance p1=runtimeService.startProcessInstanceByKey(_bussinessKey);
        Assert.assertNotNull(p1);

    }
}
