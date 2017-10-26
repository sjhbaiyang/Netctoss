package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Service;

/**
 * Created by dllo on 17/10/25.
 */
public interface ServiceService {


    PageInfo<Service> findAllService(Integer pageNo, Integer pageSize);

    Service findSerById(Integer serviceId);

    Service updateSerStatusById(Service service);

    boolean delSerById(Service service);
}
