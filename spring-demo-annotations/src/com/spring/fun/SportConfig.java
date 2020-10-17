package com.spring.fun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//@ComponentScan("com.spring.fun")
@PropertySource("sport.properties")
public class SportConfig {
	
	//define beans for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define beans for swim coach and inject the bean
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
