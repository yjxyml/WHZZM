package com.xxx.wxjsxy.form;

import com.xxx.wxjsxy.web.ActionErrors;

public class RegisterForm extends ActionForm {
    private Integer id;            //用户ID
    private String user;
    private String pw;
    private String sex;            //用户性别
    private String phone;          //用户手机号
    private String file;

    public ActionErrors validateForm() {
        ActionErrors errors=new ActionErrors();
        System.out.println("this.user="+this.user);
        System.out.println("this.pw="+this.pw);
        System.out.println("this.phone="+this.phone);
        if("".equals(this.user)||this.user==null){
            errors.addMessage("userError", "name is null");
        }
        if("".equals(this.pw)||this.pw==null){
            errors.addMessage("pwError", "pw is null");
        }
        if("".equals(this.phone)||this.phone==null){
            errors.addMessage("phoneError", "phone is null");
        }
        return errors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
