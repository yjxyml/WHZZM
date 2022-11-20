package com.xxx.wxjsxy.model;

public class User {
    private String user;        //用户名
    private String pw;          //密码
    private String uSex;        //性别
    private String uPhone;      //手机号
    private String file;        //文件地址
    private int role;           //权限

    public User() {
    }

    public User(String user, String pw) {
        this.user = user;
        this.pw = pw;
    }

    public User(String user, String pw, String uSex, String uPhone, String file) {
        this.user = user;
        this.pw = pw;
        this.uSex = uSex;
        this.uPhone = uPhone;
        this.file = file;
    }

    public User(String user, String pw, String uSex, String uPhone, String file, int role) {
        this.user = user;
        this.pw = pw;
        this.uSex = uSex;
        this.uPhone = uPhone;
        this.file = file;
        this.role = role;
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

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
