package com.hfzs.biz.sys.controller;

import com.hfzs.biz.sys.domain.SysTreeTest;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.service.ISysUserService;
import com.hfzs.biz.sys.service.impl.SysTreeTestServiceImpl;
import com.hfzs.framework.core.BaseAction;
import com.hfzs.framework.domain.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseAction {

    @Autowired
    private ISysUserService<SysUser> sysUserService;

    @Autowired
    private SysTreeTestServiceImpl sysTreeTestService;

    @RequestMapping("/user/list")
    public ModelAndView userList() {
        return new ModelAndView("/sys/user-list");
    }

    @ResponseBody
    @RequestMapping("/user/list.json")
    public Page<SysUser> userList(@RequestBody PageDto page, HttpServletRequest request) {
        Pageable pageable = genPageAble(page);
        Map<String, String[]> params = page.getSearchMap();
        Page<SysUser> pagedList = sysUserService.findAll(params, pageable);
        return pagedList;
    }


    @RequestMapping(value = "/user/{id}")
    public ModelAndView views(@PathVariable String id) {
        SysUser user = (SysUser) sysUserService.findOne(id);
        return new ModelAndView("/sys/user").addObject("user", user);
    }

    @ResponseBody
    @RequestMapping(value = "/user/delete/{id}")
    public String delete(@PathVariable String id) {
        this.sysUserService.delete(id);

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/user/TreeTest")
    public Object TreeTest() {
        List<SysTreeTest> list = sysTreeTestService.findAll();
        //禁止选中
        list.get(1).getState().setDisabled(true);
        return list;
    }
}