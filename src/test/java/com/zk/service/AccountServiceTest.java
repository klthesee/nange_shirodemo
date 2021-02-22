package com.zk.service;

import com.zk.ShiroDemoApplication;
import com.zk.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ShiroDemoApplication.class)
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void findByUsername() {
        Account zs = accountService.findByUsername("zs");
        System.out.println(zs);
    }
}