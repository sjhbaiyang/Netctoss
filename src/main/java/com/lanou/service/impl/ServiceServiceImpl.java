package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.mapper.ServiceMapper;
import com.lanou.service.ServiceService;
import com.lanou.bean.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by dllo on 17/10/25.
 */
@org.springframework.stereotype.Service("ServiceService")
public class ServiceServiceImpl implements ServiceService {
    @Resource
    private ServiceMapper serviceMapper;

    //查询全部
    public PageInfo<Service> findAllService(Integer pageNo, Integer pageSize) {
        return queryServiceByPage(pageNo, pageSize);
    }

    //按顺序查询--分页
    public PageInfo<Service> queryServiceByPage(
            Integer pageNo, Integer pageSize) {
        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<Service> allService = serviceMapper.findAllService();

        //使用pageInfo对结果进行包装
        PageInfo<Service> pageInfo = new PageInfo<Service>(allService);

        return pageInfo;
    }

    //根据id查询
    public Service findSerById(Integer serviceId) {
        return serviceMapper.selectByPrimaryKey(serviceId);
    }

    //根据id更改Ser状态
    public Service updateSerStatusById(Service service) {

        // 0, 更改为暂停状态,记载暂停时间
        if (service.getStatus().equals("0")) {
            service.setPauseDate(new Date());
        } else if (service.getStatus().equals("1")) {
            // 1, 更改为开通状态,清空暂停时间
            try {
                service.setPauseDate(new SimpleDateFormat("yyyy-MM-dd").parse("0000-00-00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        serviceMapper.updateByPrimaryKeySelective(service);
        return serviceMapper.selectByPrimaryKey(service.getServiceId());
    }

    //根据id删除
    public boolean delSerById(Service service) {

        service.setStatus("2");
        service.setCloseDate(new Date());

        int i = serviceMapper.updateByPrimaryKeySelective(service);
        if (i != 1) {
            return false;
        }

        return true;
    }
}
