package com.example.expensetrackerproject.controller;

import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class TestController {

    @Autowired
    public final ExpenseRepository expenseRepository;
    public TestController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


//    @GetMapping("/")
//    public String home() {
//        return "Hello, Expense Tracker is running!";
//    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
//        System.out.println("Adding expense: " + expense.getName() + ", Amount: " + expense.getAmount());
        return expenseRepository.save(expense);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Database connected successfully!";
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


}