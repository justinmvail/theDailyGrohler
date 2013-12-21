package com.dailyGrohler.utils;

import java.util.Random;

public class RandomNumberUtil {
	
	public static int getRandom10(){
		Random generator = new Random();
		int randomInt = generator.nextInt(10);
		return randomInt;
	}
	
	public static int getRandom5(){
		Random generator = new Random();
		int randomInt = generator.nextInt(5);
		return randomInt;
	}

}
