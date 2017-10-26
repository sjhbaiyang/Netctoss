package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface CostService{

    void addCost(Cost cost);

    boolean findByName(Cost cost);

    boolean delById(Integer costId);

    Cost findById(Integer costId);

    boolean updateStatuById(Cost cost);

    boolean editCost(Cost cost);

    PageInfo<Cost> findCostSort(Integer pageNo,Integer pageSize,Integer choose);
}
