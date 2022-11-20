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
import java.util.List;

@Component("index2.do")
public class Index2Action extends Action {

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private MessageService messageService;

    public void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if(id == 1){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
