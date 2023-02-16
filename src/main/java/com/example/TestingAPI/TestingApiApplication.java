package com.example.TestingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

@SpringBootApplication
public class TestingApiApplication {

	public static void main(String[] args) {
		System.setProperty("file.encoding","UTF-8");

		try{

			Field charset = Charset.class.getDeclaredField("defaultCharset");

			charset.setAccessible(true);

			charset.set(null,null);

		} catch(Exception e){	}

		SpringApplication application = new SpringApplication(TestingApiApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);

	}

}
