package com.xxx.wxjsxy.web;

import com.xxx.wxjsxy.form.ActionForm;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("showRegister.do")
public class ShowRegisterAction extends Action {
    public void execute(ActionForm form, ActionMapping mapping, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher(mapping.getTarge()).forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
