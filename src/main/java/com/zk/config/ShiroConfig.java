package com.zk.config;

import com.zk.domain.Account;
import com.zk.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 权限设置
        Map<String,String> map = new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        // 设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 设置没有权限的跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(
            @Qualifier("accountRealm") AccountRealm accountRealm){ // 函数参数中是下面那个bean，
                                                                // 它已经注入到容器中了，现在要在manager中使用它
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(accountRealm);
        return manager;
    }

    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }
}
