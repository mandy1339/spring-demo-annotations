package com.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coaches.Coach;

public class App1 {

	public static void main(String[] args) {
		System.out.println("app1 running");
		
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach coach1 = context.getBean("fencingCoach", Coach.class);
		Coach coach2 = context.getBean("fishKeepingCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("coach 1");
		System.out.println(coach1.getDailyWorkout());
		System.out.println(coach1.getDailyFortune());
		System.out.println("\n");
		System.out.println("coach 2");
		System.out.println(coach2.getDailyWorkout());
		System.out.println(coach2.getDailyFortune());
		
		// close the context
		context.close();

	}

}
