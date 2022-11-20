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

@Component("zone.do")
public class ZoneAction extends Action{
    @Autowired
    private ZoneService zoneService;

    @Autowired
    private MessageService messageService;
    public void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if(id == 0){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/show.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 1){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/javaweb.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 2){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/js.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 3){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/frame.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 4){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/back-end.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 5){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/language.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 6){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/java.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }else if(id == 7){
                List<Zone> zones = zoneService.selectZones();
                List<Message> messages = messageService.selectMessages();
                request.setAttribute("zones",zones);
                request.setAttribute("messages",messages);
                mapping.setTarge("/WEB-INF/structure.jsp");
                request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
