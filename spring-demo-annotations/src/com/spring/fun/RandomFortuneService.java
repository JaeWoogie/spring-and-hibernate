package com.spring.fun;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create array of strings
	private String[] data = {
			"Be aware of the dog",
			"Don't go to bed tonight",
			"Journey is the reward"
	};
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		//pick random fortune from that array
		int index = random.nextInt(data.length);
		
		String fortune = data[index];
		
		return fortune;
	}

	
}
