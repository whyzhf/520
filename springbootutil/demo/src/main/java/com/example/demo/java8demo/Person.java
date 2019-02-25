/**
 * 
 */
package com.example.demo.java8demo;

/**
 * @author why
 * 
 *
 * 类描述：
 * 创建时间：2017年9月12日 下午6:09:33
 * 修改人：dell
 * 修改时间：2017年9月12日 下午6:09:33
 * 修改备注：
 * @version
 * 2017年9月12日
 */
public class Person {
	 private String name;
	 private int age;
	 private String sex;
	 
	 
	 public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public  boolean isStudent(){

		 return  true;
	 };
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
