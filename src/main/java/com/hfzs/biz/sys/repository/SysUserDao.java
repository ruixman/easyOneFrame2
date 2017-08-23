package com.hfzs.biz.sys.repository;

import com.hfzs.framework.core.web.orm.MyJpaRepository;
import com.hfzs.biz.sys.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2017/8/9.
 */
public interface SysUserDao  extends MyJpaRepository<SysUser,String> {
    public void delete(SysUser user);

    /**
     * 直接在接口中定义查询方法，如果是符合规范的，可以不用写实现，目前支持的关键字写法如下：
     * findByFirstNameAndLastName: where X.lastname=?1 and x.firstName=?2
     * findByFirstNameORLastName: where X.lastname=?1 or x.firstName=?2
     * etc: Between LessThan GreaterThan isNull like notLike startingWith endingwith
     * not in notin true false
     *
     * 使用@Query
     可以在自定义的查询方法上使用@Query来指定该方法要执行的查询语句，比如：
     @Query("select o from UserModel o where o.uuid=?1")
     public List<UserModel> findByUuidOrAge(int uuid);
     */

//    @Query来指定本地查询，只要设置nativeQuery为true，比如：
//    @Query(value="select * from tbl_user where name like %?1" ,nativeQuery=true)
//    public List<UserModel> findByUuidOrAge(String name);

    public List<SysUser> findByLoginName(String loginName);

    //特殊的条件，如创建时间大于2017年
    @Query("select o from SysUser o where createTime>'2017-01-01' and loginName=?1")
    public List<SysUser> findByLoginName1(String loginName);


    //直接使用nativ uery,如此例需要用到md5函数，但可移殖性不好，不推荐。
    @Query(value = "select count(*) from t_sys_user_info where login_name= ?1 and password=md5(?2)",nativeQuery = true)
    public int ifValidUser(String name,String pwd);


}