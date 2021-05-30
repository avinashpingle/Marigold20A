package com.testingshastra.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

import net.bytebuddy.utility.RandomString;

public class Randomize {

	public static String email() {	
		String name = RandomString.make(8);
		String emailId = name+"@gmail.com";
		return emailId;
	}
	
	public static String mobileNumber() {
		String mobile="";
		for(int i=0;i<7;i++) {
			mobile=mobile+RandomUtils.nextInt(0, 9);
		}
		return mobile;
	}
	public static void main(String[] args) {
		System.out.println(new Randomize().mobileNumber());
	}
}
