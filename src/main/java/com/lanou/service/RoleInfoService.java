package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.RoleInfo;

/**
 * Created by dllo on 17/10/26.
 */
public interface RoleInfoService {


    PageInfo<RoleInfo> findAllRole(Integer pageNo,Integer pageSize);

    RoleInfo findRoleById(Integer roleId);

    boolean addRole(String name, String modId);

    boolean updateTheRole(Integer roleId, String name, String modIds);

    boolean deleteTheRole(Integer roleId);



}
