package com.hfzs.biz.sys.service.impl;

import com.hfzs.biz.sys.service.IActivitiService;
import org.activiti.engine.runtime.Execution;
import org.springframework.stereotype.Service;

/*** Created by Administrator on 2017/8/25.
 */
@Service("activitiService")
public class ActivitiServiceImpl implements IActivitiService{
    @Override
    public void document(Execution execution) {
        System.out.print("Execution is ::::::::::::::::");
    }
}
