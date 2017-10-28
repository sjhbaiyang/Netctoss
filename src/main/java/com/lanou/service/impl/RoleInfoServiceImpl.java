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

    //查询所有有
    public PageInfo<RoleInfo> findAllRole(Integer pageNo, Integer pageSize) {
        return queryServiceByPage(pageNo, pageSize);
    }

    //通过id查询
    public RoleInfo findRoleById(Integer roleId) {
        return roleInfoMapper.findRoleById(roleId);
    }

    //添加
    public boolean addRole(String name, String modId) {

        RoleInfo roleByName = roleInfoMapper.findRoleByName(name);
        if (roleByName != null){
            return false;
        }

        try {
            String[] split = modId.split(",");

            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setName(name);
            roleInfoMapper.insert(roleInfo);

            Integer roleId = roleInfo.getRoleId();
            //在中间表添加
            for (int i = 0; i < split.length; i++) {
                Integer moduleId = Integer.parseInt(split[i]);
                roleInfoMapper.addRole(roleId, moduleId);
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //修改
    public boolean updateTheRole(Integer roleId, String name, String modIds) {

        try {
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setRoleId(roleId);
            roleInfo.setName(name);
            //根据RId 修改
            roleInfoMapper.updateByPrimaryKeySelective(roleInfo);

            String[] split = modIds.split(",");

            //根据roleId 删除 中间表 信息
            roleInfoMapper.deleteForR_MByRId(roleId);
            //再循环添加中间表信息
            for (int i = 0 ;i < split.length;i++){
                roleInfoMapper.addRole(roleId,Integer.parseInt(split[i]));
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    //删除
    public boolean deleteTheRole(Integer roleId) {

        try {
            //根据id删除role
            roleInfoMapper.deleteByPrimaryKey(roleId);

            //根据rid删除中间表中内容
            roleInfoMapper.deleteForR_MByRId(roleId);
        }catch (Exception e){
            return false;
        }

        return true;
    }


    //查询--分页
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
