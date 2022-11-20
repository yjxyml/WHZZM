package com.xxx.wxjsxy.service;

import com.xxx.wxjsxy.dao.MessageDao;
import com.xxx.wxjsxy.dao.ZoneDao;
import com.xxx.wxjsxy.model.Message;
import com.xxx.wxjsxy.model.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MessageService")
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public List<Message> selectMessages(){
        List<Message> messages = messageDao.selectMessages();
        return messages;
    }
}
