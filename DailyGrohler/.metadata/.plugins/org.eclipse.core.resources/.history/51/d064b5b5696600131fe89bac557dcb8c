package com.dailyGrohler.main;

import java.util.Date;

import com.dailyGrohler.common.Constants;
import com.dailyGrohler.utils.Emailer;
import com.dailyGrohler.utils.RandomNumberUtil;

public class Main {
	
	static int emailInt = 0;
	public static void main(String[] args) {
		
		System.out.println("Starting!");
		while(true){
			int pictureInt = RandomNumberUtil.getRandom10();
			int quoteInt = RandomNumberUtil.getRandom10();
						
			try{
				Emailer.sendEmail(Constants.PHONE_NUMBER,
									Constants.EMAIL_SUBJECT,
									Constants.EMAIL_MESSAGE_ARRAY[quoteInt],
									Constants.PICTURE_NAMES[pictureInt],
									Constants.EMAIL_ADDRESS_ARRAY[emailInt],
									Constants.EMAIL_PASSWORD);
				Date date = new Date();
				System.out.println("---"+date+"-------------------------------");
				System.out.println(emailInt+" "+Constants.EMAIL_ADDRESS_ARRAY[emailInt]);
				System.out.println(quoteInt+" "+Constants.EMAIL_MESSAGE_ARRAY[quoteInt]);
				System.out.println(pictureInt+" "+Constants.PICTURE_NAMES[pictureInt]);
				System.out.println("--------------------------------------------------------------");
			}catch(Exception e){
				e.printStackTrace();
			}
			try {
				Thread.sleep(Constants.DURATION_THREAD_SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(emailInt<4){
				emailInt++;
			}else emailInt = 0;
		}
	}
}
