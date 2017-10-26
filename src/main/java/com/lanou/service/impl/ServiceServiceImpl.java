package com.lanou.service.impl;

import com.lanou.mapper.ServiceMapper;
import com.lanou.service.ServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author dllo
 * @date 17/10/25
 */
@Service("ServiceService")
public class ServiceServiceImpl implements ServiceService {

    @Resource
    private ServiceMapper serviceMapper;


}
