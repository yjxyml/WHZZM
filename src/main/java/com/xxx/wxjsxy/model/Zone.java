package com.xxx.wxjsxy.model;

public class Zone {
    private int id ;            //id
    private String name;        //名字
    private String description; //描述
    private String zone;        //文件头

    public Zone(int id, String name, String description,String zone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}
