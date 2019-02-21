package com.example.demo.nioDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandWDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String read(){
		try {
			FileInputStream fin = new FileInputStream( "readandshow.txt" );
			FileChannel fc = fin.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate( 1024 );
			fc.read( buffer );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	

}
