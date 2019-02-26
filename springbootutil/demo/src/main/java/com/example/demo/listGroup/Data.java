package com.example.demo.listGroup;

public class Data {
	 
    private Long id ;
    private Long courseId ;
    private String content ;
 
    public Long getId() {
        return id;
    }
 
    public Data setId(Long id) {
        this.id = id;
        return this ;
    }
 
    public Long getCourseId() {
        return courseId;
    }
 
    public Data setCourseId(Long courseId) {
        this.courseId = courseId;
        return this ;
    }
 
    public String getContent() {
        return content;
    }
 
    public Data setContent(String content) {
        this.content = content;
        return this ;
    }
    
}