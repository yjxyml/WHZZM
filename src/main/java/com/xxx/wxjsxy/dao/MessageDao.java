package com.xxx.wxjsxy.dao;

import com.xxx.wxjsxy.iservice.IMessageService;
import com.xxx.wxjsxy.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("MessageDao")
public class MessageDao implements IMessageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Message> selectMessages() {
        String sql = "select * from message";
        try {
            List<Message> messages = jdbcTemplate.query(sql, new MyRowMapper());
            //如果数组中不存在任何元素，则返回 true。 然后为null查询不到数据
            if(messages.isEmpty() == true)
            {
                return null;
            }
            return messages;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    class MyRowMapper implements RowMapper<Message>{
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = null;
            int id = Integer.parseInt(rs.getString(1));
            String content = rs.getString(2);
            String title = rs.getString(3);
            String author = rs.getString(4);
            String attention = rs.getString(5);
            String reply = rs.getString(6);
            String date = rs.getString(7);
            String img = rs.getString(8);
            String skip = rs.getString(9);
            String pageview = rs.getString(10);

            message = new Message(id,content,title,author,attention,reply,date,img,skip,pageview);
            return message;
        }
    }
}
