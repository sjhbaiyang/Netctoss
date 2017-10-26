package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.mapper.AccountMapper;
import com.lanou.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
@Service("AccountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    //查询全部
    public PageInfo<Account> findAllAccount(Integer pageNo, Integer pageSize) {
        return queryCostSortByPage(pageNo, pageSize);
    }

    //按顺序查询--分页
    public PageInfo<Account> queryCostSortByPage(
            Integer pageNo, Integer pageSize) {
        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<Account> allAccount = accountMapper.findAllAccount();

        //使用pageInfo对结果进行包装
        PageInfo<Account> pageInfo = new PageInfo<Account>(allAccount);

        return pageInfo;
    }

    //通过id更改状态
    public Account updateStatuById(Account account) {

        //更改为暂停状态,记载暂停时间
        if (account.getStatus().equals("0")) {
            account.setPauseDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        }
        if (account.getStatus().equals("1")) {
            //更改为开通状态,删除暂停时间
            account.setPauseDate("");
        }

        accountMapper.updateByPrimaryKeySelective(account);
        Account findById = accountMapper.selectByPrimaryKey(account.getAccountId());
        return findById;
    }

    //根据id查询
    public Account findInfoById(Integer accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    //查询 去重
    public List<Account> findOccDistinct() {
        List<Account> occDistinct = accountMapper.findOccDistinct();
        System.out.println(occDistinct);
        return occDistinct;
    }

    //修改 acc
    public boolean updateAcc(Account account) {
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            return false;
        }
        return true;
    }

    //添加acc

    /**
     * 返回0-登录名重复
     * 返回1-必要信息不全
     * 返回2-身份证已经注册
     * 返回6-添加成功
     *
     * @param account
     * @return
     */
    public Integer addAcc(Account account) {

        //判断登录名是否重复
        Account accByLoginName = accountMapper.findAccByLoginName(account.getLoginName());
        if (accByLoginName != null) {
            return 0;
        }

        if (account.getRealName().equals("") || account.getIdcardNo().equals("") ||
                account.getLoginName().equals("") || account.getLoginPasswd().equals("")
                || account.getTelephone().equals("")) {
            return 1;
        }

        Account accByIdCard = accountMapper.findAccByIdCard(account.getIdcardNo());
        if (accByIdCard != null) {
            return 2;
        }

        account.setStatus("1");
        account.setCreateDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        accountMapper.insertSelective(account);
        return 6;
    }

    //根据id更改状态为删除
    public boolean delAccById(Account account) {
        account.setStatus("2");
        account.setCloseDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i != 1) {
            return false;
        }
        return true;
    }

    //模糊查询
    public PageInfo<Account> fuzzySearch(Account account,Integer pageNo,Integer pageSize) {

        //判断参数的合法性
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 3 : pageSize;

        PageHelper.startPage(pageNo, pageSize);

        //获取全部的account
        List<Account> allAccount = accountMapper.fuzzySearch(account);

        //使用pageInfo对结果进行包装
        PageInfo<Account> pageInfo = new PageInfo<Account>(allAccount);

        return pageInfo;
    }

    @Override
    public Account findByIdCard(String idcardNo) {
        return accountMapper.findAccByIdCard(idcardNo);
    }


    public List<Account> findAllAccount() {
        return accountMapper.findAllAccount();
    }
}