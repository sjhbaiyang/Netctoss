package com.lanou.mapper;

import com.lanou.bean.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> findAllAccount();

    int deleteSomeById(@Param("accountId") Integer accountId);

    List<Account> findOccDistinct();

    Account findAccByLoginName(@Param("loginName") String loginName);

    Account findAccByIdCard(@Param("idcardNo") String idcardNo);

    List<Account> fuzzySearch(Account account);
}