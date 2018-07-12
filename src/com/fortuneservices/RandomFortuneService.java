package com.fortuneservices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// CLASS VARS
	@Value("${listOfFortunes}")
	private String[] firstRandomFortunes;
	
	private ArrayList<String> allTheFortunes;
	
	private Integer numOfFortunes;
	
	
	// GETTERS
	@Override
	public String getFortune() {
		int randInt = (int)(Math.random() * this.numOfFortunes);
		return this.allTheFortunes.get(randInt);
	}

	public Integer getNumOfFortunes() {
		return this.numOfFortunes;
	}
	
	// LIFE CYCLE METHODS
	@PostConstruct
	public void initMe() {
		System.out.println("RUNNING POST CONSTRUCT METHOD FOR RADFORTSERVICE BEAN");
		this.allTheFortunes = new ArrayList<String>();
		for(String str : this.firstRandomFortunes) {
			this.allTheFortunes.add(str);
		}
		File file = new File("./resources/extrafortunes.txt");
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				this.allTheFortunes.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		this.numOfFortunes = this.allTheFortunes.size();
		System.out.println("numofFortunes: " + this.numOfFortunes + "\n");
	}

	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("CLEANING UP BEFORE DESTROYING THIS BEAN");
		this.firstRandomFortunes = null;
		this.numOfFortunes = null;
		System.gc();
	}
	
}
 