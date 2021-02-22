package com.zk.domain;

import lombok.Data;

@Data
public class Account {
    /**
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `username` varchar(20) DEFAULT NULL,
     *   `password` varchar(20) DEFAULT NULL,
     *   `perms` varchar(20) DEFAULT NULL,
     *   `role` varchar(20) DEFAULT NULL,
     */
    private Integer id;
    private String username;
    private String password;
    private String perms;
    private String role;
}
