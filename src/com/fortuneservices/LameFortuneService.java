package com.fortuneservices;

import org.springframework.stereotype.Component;

@Component
public class LameFortuneService implements FortuneService {
	private String[] lameFortunes;
	
	
	public LameFortuneService() {
		this.lameFortunes = new String[]{"im lame", "im lamer", "im lamest"};
	}
	
	
	@Override
	public String getFortune() {
		int randInt = (int)(Math.random() * lameFortunes.length);
		return lameFortunes[randInt];
	}
	
//	@init
//	public void startUp() {
//		
//	}

}
