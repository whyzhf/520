/**
 * 
 */
package com.example.demo.java8demo;

/**
 * @author why
 * 
 *
 * 类描述：
 * 创建时间：2017年9月13日 上午9:05:55
 * 修改人：dell
 * 修改时间：2017年9月13日 上午9:05:55
 * 修改备注：
 * @version
 * 2017年9月13日
 */
public class ValueAbsentException extends Throwable {
		 
		  public ValueAbsentException() {
		    super();
		  }
		 
		  public ValueAbsentException(String msg) {
		    super(msg);
		  }
		 
		  @Override
		  public String getMessage() {
		    return "No value present in the Optional instance";
		  }
}

