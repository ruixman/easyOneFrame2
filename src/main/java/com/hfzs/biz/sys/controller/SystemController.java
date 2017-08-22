package com.hfzs.biz.sys.controller;

import com.hfzs.framework.core.BaseAction;
import com.hfzs.framework.domain.dto.PageDto;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseAction{

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping("/user/list")
    public ModelAndView userList(){
        return new ModelAndView("/sys/user-list");
    }

    @ResponseBody
    @RequestMapping("/user/list.json")
    public Page<SysUser> userList(@RequestBody PageDto page, HttpServletRequest request) {
        Pageable pageable= genPageAble(page);
        Map<String,String[]>  params=page.getSearchMap();
        Page<SysUser> pagedList = sysUserService.findAll(params, pageable);
        return pagedList;
    }

    //@RequestMapping(value = "/user/{id:[0-9]+}")
//    public ModelAndView views(@PathVariable String id, @RequestParam(defaultValue = "true") boolean isUpdate,
//                              HttpServletRequest request, HttpServletResponse response) {

    @RequestMapping(value = "/user/{id}")
    public ModelAndView views(@PathVariable String id) {
        SysUser user = sysUserService.getOne(id);
        return new ModelAndView("/sys/user").addObject("user",user);
    }
}
