package com.coaches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fortuneservices.FortuneService;

@Component
public class FishKeepingCoach implements Coach {
	
	private FortuneService fortuneService;


	
	@Override
	public String getDailyWorkout() {
		return "feed the fishies 5 pellets";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
		//		return "may you enjoy your fishies";
	}

    @Autowired				// SETTER INJECTION
    public void setFortuneService(FortuneService fortuneService) {
    	this.fortuneService = fortuneService;
    }
}
