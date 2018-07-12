package com.fortuneservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	String[] randomFortunes;
	
	public RandomFortuneService() {
		this.randomFortunes = new String[] {"random good luck 1", "random good luck 2", "random good luck 3"};
	}
	
	@Override
	public String getFortune() {
		int randInt = (int)(Math.random() * 3);
		return randomFortunes[randInt];
	}
}
