package com.xxx.wxjsxy.model;

import java.sql.Date;

public class Message {
    private int id;             //id
    private String content;     //内容
    private String title;       //标题
    private String author;      //作者
    private String attention;   //关注
    private String reply;       //浏览
    private String date;        //时间
    private String img;         //图片
    private String skip;        //跳转
    private String pageview;    //浏览量

    public Message(int id, String content, String title, String author, String attention, String reply, String date, String img,String skip,String pageview) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.attention = attention;
        this.reply = reply;
        this.date = date;
        this.img = img;
        this.skip = skip;
        this.pageview = pageview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getPageview() {
        return pageview;
    }

    public void setPageview(String pageview) {
        this.pageview = pageview;
    }
}
