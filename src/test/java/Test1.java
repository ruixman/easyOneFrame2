/**
 * Created by xurui on 2017/8/22.
 */

import com.hfzs.biz.sys.domain.Dept;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.repository.SysUserDao;
import com.hfzs.biz.sys.service.ISysUserService;
import com.hfzs.biz.sys.service.impl.DeptServiceImpl;
import com.hfzs.framework.core.web.Application;
import org.apache.shiro.util.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class Test1 {

    @Autowired
    private ISysUserService<SysUser> sysUserService;

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private DeptServiceImpl deptService;

    @Test
    public void testSave(){

        SysUser u = new SysUser();
        u.setName("hello22312");
        u.setLoginName("ruixman12_90");
        u.setPsw("ghiwrjiweoriow");
        u.setAddress("长江容阿迪qwqwqwqwwqwq");
        u.setCreateTime(new Date());

        sysUserService.save(u);

        SysUser u2=(SysUser)sysUserService.getOne(u.getId());

        Assert.notNull(u2);

     //   sysUserService.delete(u.getId());

    }

    @Test
    public void testJPA(){

        List<SysUser> ls= sysUserDao.findByLoginName("admin");
        Assert.isTrue(ls.size()==1);

        int counts= sysUserDao.ifValidUser("admin","555555");
        Assert.isTrue(counts==1);
   }

    @Test
    public void testJPA2(){

        List<Dept> ls= deptService.findAll();
        Assert.isTrue(ls.size()>1);

    }

}