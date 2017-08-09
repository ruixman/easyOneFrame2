package com.hfzs.framework.core.web.controller;

import com.hfzs.framework.domain.ProjectBank;
import com.hfzs.framework.repository.ProjectBankDao;
import com.hfzs.framework.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
public class HomeController {

    @Autowired
    private ProjectServiceImpl projectService;

    @RequestMapping(value = "/home")
    public ModelAndView index(){

        //测试service数据：对象数据
        ProjectBank pb1= projectService.findOne("402884905af99efc015af9a23a230001");
        System.out.println(pb1.getAcctNo());

        List<ProjectBank> list1= projectService.list();
        System.out.println(list1.size());

        //TODO:测试QueryDsl


        // TODO: 2017/7/21 加入shibo权限

        return  new ModelAndView("index");
    }
}
