package com.example.expensetrackerproject.controller;

import com.example.expensetrackerproject.DTO.ModeOfPaymentReport;
import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses/api")
public class ExpenseRestController {

    private final ExpenseService expenseService;


    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
//        System.out.println("Adding expense: " + expense.getName() + ", Amount: " + expense.getAmount());
        return expenseService.addExpense(expense);
    }

//    Fetching all the expense for a specific user
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpensesForSpecificUser();
    }


    // 3. Handle form submission (save expense)
    @PostMapping("/add")
    public List<Expense> saveExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return expenseService.getAllExpensesForSpecificUser(); // after saving → go back to list
    }

    @GetMapping("/spendbymodeofpayment")
    public List<ModeOfPaymentReport> getTotalSpendByModeOfPayment() {
        return expenseService.ReportModeOfPayment();
//            List<Expense> list = expenseService.getAllExpensesForSpecificUser();
//            HashMap<String,Long> map = new HashMap<>();
//            for(Expense e : list) {
//                String mode = e.getModeOfPayment();
//                Long amount = e.getAmount().longValue();
//                map.put(mode, map.getOrDefault(mode, 0L) + amount);
//                }
//            return map;
    }



//    @GetMapping ("/{username/password}")
//    public String getUserDetails(@PathVariable String username, @PathVariable String password) {
//        // For demonstration purposes, just return the username and password
//        return "Username: " + username + ", Password: " + password;
//        }

//    public TestController(ExpenseRepository expenseRepository) {
//        this.expenseRepository = expenseRepository;
//    }


//    @GetMapping("/")
//    public String home() {
//        return "Hello, Expense Tracker is running!";
//    }

}