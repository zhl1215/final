package com.baizhi.util;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
	
	public static String getSalt(){
		//随机产生盐
		char[] array = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		
		StringBuilder sbu = new StringBuilder("");
		Random random = new Random();
		
		for(int i=1;i<=6;i++){
			int num = random.nextInt( array.length );
			sbu.append(array[num]);
		}
		
		return sbu.toString();
	}
	//MD5加密
	//src为原生密码
	public static String encryption(String src){
		return DigestUtils.md5Hex(src);	
	}
	//验证密码
	public static boolean checkPassword(String src,String pwd){
		if( src == null ) throw new RuntimeException();
		if( pwd == null ) throw new RuntimeException();
		return  encryption(src).equals(pwd) ;
	}
	
}
