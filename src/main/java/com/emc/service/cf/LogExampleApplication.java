package com.emc.service.cf;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@RestController
public class LogExampleApplication {

	private AtomicLong counter = new AtomicLong();

	@Scheduled(initialDelay = 5000, fixedRate = 1000)
	public void logging() throws IOException {
		System.out.println(counter.incrementAndGet());
	}

	@RequestMapping(value = "/", produces = "text/plain")
	public String info() {
		return "i am logging data pretty often";
	}


	public static void main(String[] args) {
		SpringApplication.run(LogExampleApplication.class, args);
	}
}
