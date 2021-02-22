package com.zk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.domain.Account;
import com.zk.mapper.AccountMapper;
import com.zk.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public Account findByUsername(String username) {
        Account account = baseMapper.selectOne(new QueryWrapper<Account>().eq("username", username));
        return account;
    }
}
