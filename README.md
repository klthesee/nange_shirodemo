# nange_shirodemo


1. 与spring security一样它也提供认证（登录）、授权功能、会话管理、加密
2. 为什么有shiro？ 不用shiro,用多个过滤器也能实现，但是代码不能统一接口。--》需要统一接口---》shiro
3. shiro核心组件：
用户、角色、权限
给角色赋予权限，给用户赋予角色
用户不是直接跟权限挂钩，而是通过角色间接挂钩权限

- UsernamePasswordToken, 封装用户登录信息，创建token
- SecurityManager，负责安全认证和授权
- Subject，shiro的一个抽象概念，取用户信息，包含用户信息
- Realm：开发者自定义模块，认证、授权的逻辑都写在Realm中
- AuthenticationInfo,用户的角色集合，认证时使用，做具体事情时认证
- AuthorizationInfo,角色权限集合，授权时使用
- DefaultWebSecurityManager,安全管理器，开发者自定义的Realm需要注入到DefaultWebSecurityManager进行管理才能生效。
- ShiroFilterFactoryBean，

没有认证的让他去认证，认证成功的根据ta是什么角色，然后赋予ta什么权限


4. 与springboot整合
1）
2）自定义shiro过滤器,写在realm里面

- 编写认证和授权规则
> 认证过滤器：

anon：无需认证
authc: 必须认证 
authBasic：需要通过HttpBasic认证
user: 不一定认证通过，只要曾经被shiro记录，比如记住我
> 授权过滤器

perms：必须拥有某个权限才能访问
role：必须拥有某个角色
port：必须有某个端口值才可以访问
rest：请求必须基于restful
ssl：必须是https协议







