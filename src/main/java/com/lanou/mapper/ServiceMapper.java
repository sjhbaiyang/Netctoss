package com.lanou.mapper;

import com.lanou.bean.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceId);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    List<Service> findAllService();

    Service findSerByHost(String unixHost);

    List<Service> fuzzySearchForSer(@Param("status") String status,
                                    @Param("unixHost")String unixHost,
                                    @Param("osUsername")String osUsername,
                                    @Param("idcardNo") String idcardNo);

}