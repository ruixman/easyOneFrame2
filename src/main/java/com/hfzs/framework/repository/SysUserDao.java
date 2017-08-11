package com.hfzs.framework.repository;

import com.hfzs.framework.core.web.orm.MyJpaRepository;
import com.hfzs.framework.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Administrator on 2017/8/9.
 */
public interface SysUserDao  extends MyJpaRepository<SysUser,String> {

    public Page<SysUser> findAll(Specification<SysUser> spec, Pageable pageable);
}
