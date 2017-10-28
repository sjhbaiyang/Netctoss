package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.mapper.RoleInfoMapper;

import com.lanou.service.RoleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Service("RoleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
    @Resource
    private RoleInfoMapper roleInfoMapper;

    public PageInfo<RoleInfo> findAllRole(Integer pageNo,Integer pageSize) {
        return queryServiceByPage(pageNo,pageSize);
    }

    public RoleInfo findRoleById(Integer roleId) {
        return roleInfoMapper.findRoleById(roleId);
    }

    //按顺序查询--分页
    public PageInfo<RoleInfo> queryServiceByPage(
            Integer pageNo, Integer pageSize) {
        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<RoleInfo> allRole = roleInfoMapper.findAllRole();

        //使用pageInfo对结果进行包装
        PageInfo<RoleInfo> pageInfo = new PageInfo<RoleInfo>(allRole);

        return pageInfo;
    }
}
