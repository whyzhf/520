package com.example.demo.jiami;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class demo3 {
	public static void main(String[] args) {
		 String str="f4cdc07c050b95a4521e3be93e356451cc35d993";
			System.out.println(str.length());
		/* byte[] data = null;
		try {
			data = str.getBytes("UTF-8");
			byte[] str2=encryptSHA(data);
			 String t = new String(str2,"UTF-8");
			 System.out.println(t);
			 for (int i = 0; i < str2.length; i++) {
				System.out.println(str2.length+":::"+str2[i]);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
	}
	
	public static byte[] encryptSHA(byte[] data) throws Exception {
	        MessageDigest sha = MessageDigest.getInstance("AES");
	        sha.update(data);
	 
	        return sha.digest();
	 
	    }
}
