package com.hfzs.biz.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","/index.htm","/index.html","/index"})
    public ModelAndView index(){

        //TODO:测试QueryDsl

        // TODO: 2017/7/21 加入shibo权限

        return  new ModelAndView("index");
    }


}
