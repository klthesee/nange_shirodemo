package com.zk.realm;

import com.zk.domain.Account;
import com.zk.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm { // Realm写好后还需要进行配置

    @Autowired
    private AccountService accountService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account)subject.getPrincipal();

        // 设置角色
        String role = account.getRole();
        Set<String> roles = new HashSet<>();
        roles.add(role);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        // 设置权限
        info.addStringPermission(account.getPerms());

        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken; // 客户端传过来的token，里面包含了用户信息（账号、密码）
        Account account = accountService.findByUsername(token.getUsername());
        // 将用户传过来的用户名密码和数据库中的用户名密码进行比对
        if (account!=null){
            return new SimpleAuthenticationInfo(account,account.getPassword(),account.getUsername());
        }
        return null;
    }
}
