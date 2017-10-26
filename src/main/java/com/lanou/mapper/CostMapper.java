package com.lanou.mapper;

import com.lanou.bean.Cost;

import java.util.List;

public interface CostMapper {
    int deleteByPrimaryKey(Integer costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    Cost findBySomeInfo(Cost cost);

    List<Cost> findAllCost();


    //基费升序查询
    List<Cost> findCostAsc();

    //基费降序查询
    List<Cost> findCostDesc();

    //时长升序查询
    List<Cost> findDurationAsc();

    //时长降序查询
    List<Cost> findDurationDesc();
}