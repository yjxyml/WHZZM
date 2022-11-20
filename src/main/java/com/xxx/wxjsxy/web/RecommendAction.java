package com.xxx.wxjsxy.web;

import com.xxx.wxjsxy.form.ActionForm;
import com.xxx.wxjsxy.model.Message;
import com.xxx.wxjsxy.model.Zone;
import com.xxx.wxjsxy.service.MessageService;
import com.xxx.wxjsxy.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Component("recommend.do")
public class RecommendAction extends Action{

    @Autowired
    private MessageService messageService;
    List<Message> list = null;
    @Autowired
    private ZoneService zoneService;

    public void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if(id == 1){
                mapping.setTarge("/WEB-INF/third.jsp");
                setAttributes(request,response,mapping);
            }else {
                mapping.setTarge("/WEB-INF/recommend.jsp");
                setAttributes(request,response,mapping);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setAttributes(HttpServletRequest request, HttpServletResponse response,ActionMapping mapping){          //设置重复推荐
       try {
           List<Message> messages = messageService.selectMessages();
           list = new ArrayList<Message>();
           for (Message message : messages) {
               if(message.getId() % 2 == 1){
                   list.add(message);
               }
           }
           List<Zone> zones = zoneService.selectZones();
           request.setAttribute("zones",zones);
           request.setAttribute("messages",list);
           request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
