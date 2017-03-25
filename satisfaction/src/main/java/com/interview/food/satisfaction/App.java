package com.interview.food.satisfaction;

/**
 * This is an Example SpringBoot Application
 * 
 * Scenario:
 * Gordon Ramsey, a very smart guy, likes eating food. 
 * Now, Gordon is at a restaurant and he has many different types of food to choose from. 
 * Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. 
 * Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant
 * 
 * This CommandLine Runner will take the file path and will start Embedded Tomcat Container
 * 
 */

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.interview.food.satisfaction.utils.InputFileReader;

@SpringBootApplication
public class App implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Hello ! Welcome to  Spring Boot Demo Application");
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please Enter Path of File:  ");
			String text = scanner.nextLine();
			System.out.println("Entered Path for the Data File is: " + text);
			InputFileReader.inputPath = text;

		}

		System.out
				.println("Please Enter localhost:8080 in your favourite Browser ");
		System.out
				.println("Please Enter localhost:8080/{inputTime} in your favourite Browser ");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
