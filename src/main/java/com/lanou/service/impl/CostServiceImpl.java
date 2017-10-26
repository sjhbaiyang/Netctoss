package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dllo
 * @date 17/10/20
 */
@Service("CostService")
public class CostServiceImpl implements CostService {
    @Resource
    private CostMapper costMapper;

    //添加cost信息
    @Override
    public void addCost(Cost cost) {
        cost.setStatus("0");

        cost.setCreatime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        costMapper.insertSelective(cost);
    }

    //通过name查询
    @Override
    public boolean findByName(Cost cost) {
        Cost someInfo = costMapper.findBySomeInfo(cost);
        if (someInfo == null) {
            //未找到,返回true,用于判断添加名称时是否重复
            return true;
        }
        return false;
    }

    //根据id删除
    @Override
    public boolean delById(Integer costId) {
        int i = costMapper.deleteByPrimaryKey(costId);
        //删除成功
        if (i == 1) {
            return true;
        }
        return false;
    }

    //根据id查询
    @Override
    public Cost findById(Integer costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    //根据id更改状态
    @Override
    public boolean updateStatuById(Cost cost) {
        cost.setStatus("1");

        cost.setStartime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        int i = costMapper.updateByPrimaryKeySelective(cost);
        //修改成功
        if (i == 1) {
            return true;
        }
        return false;
    }

    //修改cost
    @Override
    public boolean editCost(Cost cost) {

        Cost someInfo = costMapper.findBySomeInfo(cost);
        //若名字重复,返回false
        if (someInfo != null) {
            return false;
        }

        int i = costMapper.updateByPrimaryKeySelective(cost);
        if (i != 1) {
            return false;
        }
        return true;
    }

    //按顺序查询
    @Override
    public PageInfo<Cost> findCostSort(Integer pageNo, Integer pageSize, Integer choose) {
        return queryCostSortByPage(pageNo, pageSize, choose);
    }

    @Override
    public List<Cost> findAllCost() {
        return costMapper.findAllCost();
    }

    //按顺序查询--分页
    public PageInfo<Cost> queryCostSortByPage(
            Integer pageNo, Integer pageSize, Integer choose) {
        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的blog
        List<Cost> costList = null;

        if (choose == 0){
            costList = costMapper.findAllCost();
        }else if (choose == 1) {
            costList = costMapper.findCostAsc();
        }else if (choose == 2){
            costList = costMapper.findCostDesc();
        }else if (choose == 3){
            costList = costMapper.findDurationAsc();
        }else if (choose == 4){
            costList = costMapper.findDurationDesc();
        }

        //使用pageInfo对结果进行包装
        PageInfo<Cost> pageInfo = new PageInfo<Cost>(costList);

        return pageInfo;
    }
}
