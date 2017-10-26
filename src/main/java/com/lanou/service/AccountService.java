package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;

import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
public interface AccountService {
    PageInfo<Account> findAllAccount(Integer pageNo, Integer pageSize);

    List<Account> findAllAccount();

    Account updateStatuById(Account account);

    Account findInfoById(Integer accountId);

    List<Account> findOccDistinct();

    boolean updateAcc(Account account);

    Integer addAcc(Account account);

    boolean delAccById(Account account);

    PageInfo<Account> fuzzySearch(Account account,Integer pageNo,Integer pageSize);

    Account findByIdCard(String idcardNo);
}
