/**
 * Created by xurui on 2017/8/22.
 */
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.service.impl.SysUserServiceImpl;
import com.hfzs.framework.core.web.Application;
import org.apache.shiro.util.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class Test1 {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Test
    public void testSave(){

        SysUser u = new SysUser();
        u.setName("hello");
        u.setLoginName("ruixman");
        u.setPsw("ghiwrjiweoriow");
        u.setAddress("长江容阿迪");
        u.setCreateTime(new Date());

        sysUserService.saveAndFlush(u);

        Assert.notNull(u.getId());
        sysUserService.getOne(u.getId());

        sysUserService.delete(u.getId());

    }


}
