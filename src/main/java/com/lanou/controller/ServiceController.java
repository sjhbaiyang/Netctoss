package com.lanou.controller;

import com.lanou.service.ServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dllo
 * @date 17/10/25
 */
@Controller
public class ServiceController {

    @Resource
    private ServiceService serviceService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping("/service/service_list")
    public String ServiceList(){

        return "service/service_list";
    }



}
