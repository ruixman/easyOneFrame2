package com.hfzs.biz.sys.repository;

import com.hfzs.biz.sys.domain.UserInfo;
import com.hfzs.framework.core.web.orm.MyJpaRepository;

/**
 * Created by xurui on 2017/8/26.
 */

public interface UserDao  extends MyJpaRepository<UserInfo,String>{

    public UserInfo findByLoginName(String loginName);
}
