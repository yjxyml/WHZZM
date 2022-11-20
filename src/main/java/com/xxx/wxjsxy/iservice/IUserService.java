package com.xxx.wxjsxy.iservice;

import com.xxx.wxjsxy.model.User;

import java.util.List;

public interface IUserService {
    //用户登录
    List<User> userLogin(User user);
    //注册用户
    int insertUser(User user);
}
