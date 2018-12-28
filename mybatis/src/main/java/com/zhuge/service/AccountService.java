package com.zhuge.service;

public interface AccountService {

    void transfer(int user1, int user2, int money,boolean throwEx) throws Exception;
}
