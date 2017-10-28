package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.service.RoleInfoService;

import com.lanou.utils.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/26.
 */
@Controller
public class RoleInfoController {
    @Resource
    private RoleInfoService roleInfoService;

    //到角色管理界面
    @RequestMapping(value = "role/role_list")
    public String role_list(){
        return "role/role_list";
    }

    //到角色修改界面
    @RequestMapping(value = "/role_modi")

    public String role_modi(){
        return "role/role_modi";
    }

    //到增加页面
    @RequestMapping(value = "/role_add")
    public String role_add(){
        return "role/role_add";
    }

    //查询全部role
    @ResponseBody
    @RequestMapping(value = "/findAllRole",method = RequestMethod.POST)
    public AjaxResult findAllRole(@Param("pageNo")Integer pageNo,
                                  @Param("pageSize")Integer pageSize){
        PageInfo<RoleInfo> allRole = roleInfoService.findAllRole(pageNo, pageSize);
        return new AjaxResult(allRole);
    }

    //根据id查询
    @ResponseBody
    @RequestMapping(value = "/findRoleById",method = RequestMethod.POST)
    public RoleInfo findRoleById(@Param("roleId")Integer roleId){
        System.out.println(roleId);
        RoleInfo roleById = roleInfoService.findRoleById(roleId);
        System.out.println(roleById);
        return roleById;
    }

    //添加rol
    @ResponseBody
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public boolean addRole(@Param("name")String name,
                           @Param("modId")String modId){
        return roleInfoService.addRole(name,modId);
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateTheRole",method = RequestMethod.POST)
    public boolean updateTheRole(@RequestParam("roleId")Integer roleId,
                                 @RequestParam("name")String name,
                                 @RequestParam("modIds")String modIds){
        return roleInfoService.updateTheRole(roleId,name,modIds);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deleteTheRole",method = RequestMethod.POST)
    public boolean deleteTheRole(@RequestParam("roleId")Integer roleId){
        return roleInfoService.deleteTheRole(roleId);
    }


}
