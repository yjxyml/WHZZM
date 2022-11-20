package com.xxx.wxjsxy.iservice;

import com.xxx.wxjsxy.model.Message;

import java.util.List;

public interface IMessageService {
    List<Message> selectMessages();       //查找所有的话题
}
