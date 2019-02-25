package com.zhf.why.model;

/**
 *
 */
public class ZhfCreateFile {

    //文件的id
    private int Id;
    //文件夹名称
    private String Name;
    //文件夹路径
    private String Path;
    //文件夹的父id
    private int ParId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public int getParId() {
        return ParId;
    }

    public void setParId(int parId) {
        ParId = parId;
    }

    @Override
    public String toString() {
        return "ZhfCreateFile{" + "Id=" + Id + ", Name='" + Name + '\'' + ", Path='" + Path + '\'' + ", ParId=" + ParId + '}';
    }
}
