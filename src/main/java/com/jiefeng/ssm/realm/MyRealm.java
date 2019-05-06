package com.jiefeng.ssm.realm;

import com.jiefeng.ssm.bean.LoginAccount;
import com.jiefeng.ssm.dao.LoginAccountDao;
import com.jiefeng.ssm.dao.UserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginAccountDao loginAccountDao;

    //用于返回当前Realm的名字
    @Override
    public String getName() {
        return "MyRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        //将两个List封装，将其返回出去，方便进行对比
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (String item : userDao.getUserRole(username)) {
            logger.info(item);
        }
        simpleAuthorizationInfo.addRoles(userDao.getUserRole(username));
        simpleAuthorizationInfo.addStringPermissions(userDao.getUserPermission(username));
        return simpleAuthorizationInfo;
    }

    //
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //看数据库中是否有用户名，如果有的话将用户数据取出来
        //这里不连接数据库，用硬编码的方式编写
        LoginAccount account = loginAccountDao.getAccountByUsername(username);

        if(account == null){
            throw new UnknownAccountException();//没有此用户
        }

        String password = account.getPassword();

        //将查询出来的数据返回出去方便认证
        //参数（用户名，数据库拿回来的密码，当前Realm的名字)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(username),getName());

        return info;
    }
}