package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.mapper.AdminInfoMapper;
import com.lanou.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/28.
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminInfoMapper adminInfoMapper;

    //查询全部
    public PageInfo<AdminInfo> findAllAdmin(Integer pageNo,Integer pageSize) {
        return queryServiceByPage(pageNo,pageSize);
    }

    //删除
    public boolean deleteTheAdmin(Integer adminId) {

        try {
            //根据id删除admin
            adminInfoMapper.deleteByPrimaryKey(adminId);

            //根据rid删除中间表中内容
            adminInfoMapper.deleteForA_RByAId(adminId);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    //查询--分页
    public PageInfo<AdminInfo> queryServiceByPage(
            Integer pageNo, Integer pageSize) {
        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<AdminInfo> allAdmin = adminInfoMapper.findAllAdmin();

        //使用pageInfo对结果进行包装
        PageInfo<AdminInfo> pageInfo = new PageInfo<AdminInfo>(allAdmin);

        return pageInfo;
    }

}
