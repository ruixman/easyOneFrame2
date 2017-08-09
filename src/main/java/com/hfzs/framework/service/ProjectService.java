package com.hfzs.framework.service;

import com.hfzs.framework.domain.ProjectBank;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public interface ProjectService {

    public ProjectBank findOne(String id);

    public List<ProjectBank> list();
}
