package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Service;
import com.lanou.service.ServiceService;
import com.lanou.utils.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/25.
 */
@Controller
public class ServiceController {
    @Resource
    private ServiceService serviceService;

    //跳转到业务页面
    @RequestMapping(value = "service/service_list")
    public String service_list() {
        return "service/service_list";
    }

    //跳转到修改页面
    @RequestMapping(value = "/service_modi")
    public String service_modi() {
        return "service/service_modi";
    }

    //跳转到增加页面
    @RequestMapping(value = "/service_add")
    public String service_add(){
        return "service/service_add";
    }

    //查询全部
    @ResponseBody
    @RequestMapping(value = "/findAllService", method = RequestMethod.POST)
    public AjaxResult findAllService(@Param("pageNo") Integer pageNo,
                                     @Param("pageSize") Integer pageSize) {
        PageInfo<Service> allService = serviceService.findAllService(pageNo, pageSize);
        return new AjaxResult(allService);
    }

    //到显示当前用户信息页面
    @RequestMapping(value = "/service_detail")
    public String service_detail() {
        return "service/service_detail";
    }

    //根据id查询
    @ResponseBody
    @RequestMapping(value = "/findSerInfo", method = RequestMethod.POST)
    public Service findSerInfo(@Param("serviceId") Integer serviceId) {
        return serviceService.findSerById(serviceId);
    }

    //更改业务状态
    @ResponseBody
    @RequestMapping(value = "/updateSerStatus", method = RequestMethod.POST)
    public AjaxResult updateSerStatus(@Param("service") Service service) {
        Service service1 = serviceService.updateSerStatusById(service);
        return new AjaxResult(service1);
    }

    //删除Acc
    @ResponseBody
    @RequestMapping(value = "/delSer", method = RequestMethod.POST)
    public boolean delAcc(@Param("service") Service service) {
        return serviceService.delSerById(service);
    }

    //添加ser
    @ResponseBody
    @RequestMapping(value = "/submSerInfo",method = RequestMethod.POST)
    public Service submCostInfo(@Param("service")Service service){
        return serviceService.addService(service);
    }

    //模糊查询
    @ResponseBody

    @RequestMapping(value = "/fuzzySearchForSer",method = RequestMethod.POST)
    public AjaxResult fuzzySearchForSer(@Param("idcardNo")String idcardNo,
                                        @Param("service")Service service,
                                        @Param("pageNo")Integer pageNo,
                                        @Param("pageSize")Integer pageSize){
        System.out.println("111:--" );
        System.out.println(idcardNo);
        System.out.println(service);
        PageInfo<Service> service1 = serviceService.fuzzySearchForSer(idcardNo,service,pageNo,pageSize);
        return new AjaxResult(service1);
    }
}
