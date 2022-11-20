package com.xxx.wxjsxy.web;

import com.xxx.wxjsxy.form.ActionForm;
import com.xxx.wxjsxy.form.LoginForm;
import com.xxx.wxjsxy.model.Message;
import com.xxx.wxjsxy.model.User;
import com.xxx.wxjsxy.model.Zone;
import com.xxx.wxjsxy.service.MessageService;
import com.xxx.wxjsxy.service.UserService;
import com.xxx.wxjsxy.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component("login.do")
public class LoginAction extends Action {
    static int userId = 1;         //用户
    static int administrator = 2;  //管理员

    @Autowired
    private UserService userService;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private MessageService messageService;

    public void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginForm lf=(LoginForm)form;
            User user = new User(lf.getUser(), lf.getPw());
            List<User> users = userService.userLogin(user);
            List<Zone> zones = zoneService.selectZones();
            List<Message> messages = messageService.selectMessages();
            if(users!=null){
                for (User user1 : users) {
                    if(user1.getRole() == userId ){
                        mapping.setTarge("/WEB-INF/first.jsp");
                        request.setAttribute("zones",zones);
                        request.setAttribute("messages",messages);
                        request.getSession().setAttribute("user",user1);
                        request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
                    }else if(user1.getRole() == administrator){
                        mapping.setTarge("/WEB-INF/administrator.jsp");
                        request.setAttribute("file",user1.getFile());
                        request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
                    }
                }
            }else{
                ActionErrors errors=form.validateForm();
                errors.addMessage("userAndpw","账号密码错误");
                request.setAttribute("errors", errors);
                request.setAttribute("form", form);
                request.getRequestDispatcher(mapping.getValidateTarget()).forward(request, response);
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
