package com.xxx.wxjsxy.service;

import com.xxx.wxjsxy.dao.UserDao;
import com.xxx.wxjsxy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> userLogin(User user) {
        List<User> users = userDao.userLogin(user);
        return users;
    }

    public int insertUser(User user){
        int i = userDao.insertUser(user);
        return i;
    }
}
