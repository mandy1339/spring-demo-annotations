package com.coaches;

import org.springframework.stereotype.Component;

@Component
public class FencingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "puncture him 2x";
	}

	@Override
	public String getDailyFortune() {
		return "good luck";
	}

}
