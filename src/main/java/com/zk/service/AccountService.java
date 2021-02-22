package com.zk.service;

import com.zk.domain.Account;

public interface AccountService {
    Account findByUsername(String username);
}
