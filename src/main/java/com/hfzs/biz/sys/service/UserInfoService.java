package com.hfzs.biz.sys.service;

import com.hfzs.biz.sys.domain.UserInfo;
import com.hfzs.biz.sys.repository.UserDao;
import com.hfzs.framework.core.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xurui on 2017/8/26.
 */
@Service
public class UserInfoService extends BaseServiceImpl<UserInfo>{

    @Autowired
    private UserDao userDao;

    public UserInfo findByUsername(String username) {
        return userDao.findByLoginName(username);
    }
}
