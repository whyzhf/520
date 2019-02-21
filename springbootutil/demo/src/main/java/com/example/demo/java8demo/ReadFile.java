/**
 * 
 */
package com.example.demo.java8demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author why
 * 
 *
 * 类描述：
 * 创建时间：2017年9月20日 上午9:28:32
 * 修改人：dell
 * 修改时间：2017年9月20日 上午9:28:32
 * 修改备注：
 * @version
 * 2017年9月20日
 */
public class ReadFile {

	/**
	 * 使用java8读取文件看起来代码简单,但是需要注意文件编码格式,不然容易出现Input length = 1
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String fileName = "F://BugReport.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		list.forEach(System.out::println);*/
		
		 try {
			String fileData = Files.lines(Paths.get("F://in.xlsx"), Charset.forName("")) .collect(Collectors.joining("\r\n")).toString();
			System.out.println(fileData);
//			Files.lines(Paths.get("F://in.xlsx"), StandardCharsets.UTF_8).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}
