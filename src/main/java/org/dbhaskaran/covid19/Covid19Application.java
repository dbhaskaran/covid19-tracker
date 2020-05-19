package org.dbhaskaran.covid19;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19Application {
	private static final Logger logger = LoggerFactory.getLogger(Covid19Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
		logger.info("Started Covid App...................");
	}

}
