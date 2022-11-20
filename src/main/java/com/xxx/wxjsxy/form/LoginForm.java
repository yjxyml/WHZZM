package com.xxx.wxjsxy.form;

import com.xxx.wxjsxy.web.ActionErrors;

public class LoginForm extends ActionForm {
    private String user;
    private String pw;
    private String role;

    public void setUser(String user) {
        this.user = user;
    }
    public String getPw() {
        return pw;
    }
    public String getUser() {
        return user;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public ActionErrors validateForm() {
        ActionErrors errors=new ActionErrors();
        System.out.println("this.user="+this.user);
        System.out.println("this.pw="+this.pw);
        if("".equals(this.user)||this.user==null){
            errors.addMessage("userError", "name is null");
        }
        if("".equals(this.pw)||this.pw==null){
            errors.addMessage("pwError", "pw is null");
        }
        return errors;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
