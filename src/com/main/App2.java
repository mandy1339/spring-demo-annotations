package com.main;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coaches.Coach;

public class App2 {

	public static void main(String[] args) {
		
		

		
		
		
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach1 = context.getBean("fishKeepingCoach", Coach.class);
		Coach coach2 = context.getBean("fishKeepingCoach", Coach.class);
		
		// call methods on the beans
		System.out.println("COACH1 NUM OF ");
		boolean isSameObj = (coach1 == coach2);
		System.out.println("SAME OBJECT ?: " + isSameObj);
		
		// close the context
		context.close();
	}

}
