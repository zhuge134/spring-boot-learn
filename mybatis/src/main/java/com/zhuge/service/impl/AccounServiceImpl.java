package com.zhuge.service.impl;

import com.zhuge.dao.AccountMapper;
import com.zhuge.domain.Account;
import com.zhuge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccounServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void transfer(int user1, int user2, int money, boolean throwEx) throws Exception {
        Account user1old = accountMapper.selectByPrimaryKey(user1);
        Account user2old = accountMapper.selectByPrimaryKey(user2);
        user1old.setMoney(user1old.getMoney() - money);
        user2old.setMoney(user2old.getMoney() + money);
        accountMapper.updateByPrimaryKey(user1old);
        if (throwEx) {
            throw new RuntimeException();
        }
        accountMapper.updateByPrimaryKey(user2old);
    }
}
