package com.zhf.why.model;

import java.util.ArrayList;

public class ZhfFileNode {

    private int id;
    private String name;
    private  String parName;
    private  String path;
    private  int type;
    private int parId;

    //ppp
    private ArrayList<ZhfFileNode> children;
    public ZhfFileNode() {
        super();
        children = new ArrayList<ZhfFileNode>();
    }

    public void addChildren(ZhfFileNode mix) {
        this.children.add(mix);
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

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName = parName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParId() {
        return parId;
    }

    public void setParId(int parId) {
        this.parId = parId;
    }

    public ArrayList<ZhfFileNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ZhfFileNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ZhfFileNode{" + "id=" + id + ", name='" + name + '\'' + ", parName='" + parName + '\'' + ", path='" + path + '\'' + ", type=" + type + ", parId=" + parId + ", children=" + children + '}';
    }
}
