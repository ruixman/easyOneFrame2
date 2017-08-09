package com.hfzs.framework.core.web.controller;

import com.hfzs.framework.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping("/user/list")
    public ModelAndView userList(){

        return new ModelAndView("/sys/user-list");
    }

    @RequestMapping(value = "/user/{id:[0-9]+}")
    public ModelAndView views(@PathVariable Integer id, @RequestParam(defaultValue = "true") boolean isUpdate,
                      HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/sys/user").addObject("id",id);
    }
}
