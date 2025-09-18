package com.example.expensetrackerproject;

import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.model.Users;
import com.example.expensetrackerproject.repository.ExpenseRepository;
import com.example.expensetrackerproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication

public class ExpenseTrackerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerProjectApplication.class, args);



	}


	// Dummy Data Insertion
//	// Uncomment the below code to insert dummy data on application startup
//	@Bean
//	CommandLineRunner loadData(UserRepository usersRepo, ExpenseRepository expensesRepo) {
//		return args -> {
//			// Create user
//			Users user = new Users();
//			user.setUsername("testuser");
//			user.setPassword("password123");
//			usersRepo.save(user);
//
//			// Create expense for that user
//			Expense expense = new Expense();
//			expense.setDescription("Lunch");
//			expense.setAmount(250.0);
//			expense.setCategory("Food");
//			expense.setDate(LocalDate.now());
//			expense.setUser(user);
//			expensesRepo.save(expense);
//
//			System.out.println("✅ Dummy Data Inserted");
//		};
//	}

}

