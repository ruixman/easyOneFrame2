package com.hfzs.framework.service.impl;

import com.hfzs.framework.domain.ProjectBank;
import com.hfzs.framework.repository.ProjectBankDao;
import com.hfzs.framework.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectBankDao projectBankDao;

//    public void setProjectBankDao(ProjectBankDao projectBankDao) {
//        this.projectBankDao = projectBankDao;
//    }

    @Override
    public ProjectBank findOne(String id) {

        return projectBankDao.findOne(id);
    }


    @Override
    public List<ProjectBank> list(){
        return projectBankDao.findAll();
    }

}
