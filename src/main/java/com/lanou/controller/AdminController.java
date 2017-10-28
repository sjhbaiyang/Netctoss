package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.service.AdminService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/28.
 */
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

    //跳转到管理员界面
    @RequestMapping(value = "admin/admin_list.html")
    public String admin_list(){
        return "admin/admin_list";
    }

    //跳转到修改界面
    @RequestMapping(value = "/admin_modi")
    public String admin_modi(){
        return "admin/admin_modi";
    }

    //跳转到增加页面
    @RequestMapping(value = "/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }

    //查询全部admin
    @ResponseBody
    @RequestMapping(value = "/findAllAdmin",method = RequestMethod.POST)
    public AjaxResult findAllAdmin(@RequestParam("pageNo")Integer pageNo,
                                   @RequestParam("pageSize")Integer pageSize){

        PageInfo<AdminInfo> allAdmin = adminService.findAllAdmin(pageNo,pageSize);
        return new AjaxResult(allAdmin);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deleteTheAdmin",method = RequestMethod.POST)
    public boolean deleteTheAdmin(@RequestParam("adminId")Integer adminId){
        return adminService.deleteTheAdmin(adminId);
    }

}
