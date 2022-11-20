package com.xxx.wxjsxy.dao;

import com.xxx.wxjsxy.iservice.IUserService;
import com.xxx.wxjsxy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("UserDao")
public class UserDao implements IUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> userLogin(User user) {
        String sql = "select * from user where user.uname = '"+user.getUser()+"' and user.upwd = '"+user.getPw()+"'";
        try{
            List<User> users = jdbcTemplate.query(sql,new MyRowMapper());
            //如果数组中不存在任何元素，则返回 true。 然后为null查询不到数据
            if(users.isEmpty() == true)
            {
                return null;
            }
            return users;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public int insertUser(User user) {
        String sql = "insert into user values(null,'"+user.getUser()+"','"+user.getPw()+"','"+user.getuSex()+"','"+user.getuPhone()+"','"+user.getFile()+"',1)";
//        System.out.println(sql);
        int insert = jdbcTemplate.update(sql);
        return insert;
    }

    class MyRowMapper implements RowMapper<User>
    {
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = null;
            String id = resultSet.getString(1);
            String uname = resultSet.getString(2);
            String upwd = resultSet.getString(3);
            String usex = resultSet.getString(4);
            String uphone = resultSet.getString(5);
            String file = resultSet.getString(6);
            int role = Integer.parseInt(resultSet.getString(7));
            System.out.println("id="+id);
            System.out.println("uname="+uname);
            System.out.println("upwd="+upwd);
            System.out.println("usex="+usex);
            System.out.println("uphone="+uphone);
            System.out.println("file="+file);
            System.out.println("role="+role);
            user = new User(uname,upwd,usex,uphone,file,role);
            return user;
        }
    }

}
