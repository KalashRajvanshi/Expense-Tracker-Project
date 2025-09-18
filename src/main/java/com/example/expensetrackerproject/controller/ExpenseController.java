package com.example.expensetrackerproject.controller;

import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {


    private final ExpenseService expenseService;
//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
//
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/getAllExpenses")
    public String getAllExpenses(Model model) {
        model.addAttribute("expenses",expenseService.getAllExpensesForSpecificUser());
        return "list-expenses";
    }

    // 2. Show form to add a new expense
    @GetMapping("/add")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense()); // bind form to Expense object
        return "add-expense"; // loads add-expense.html
    }

    // 3. Handle form submission (save expense)
    @PostMapping("/add")
    public String saveExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenses/getAllExpenses"; // after saving → go back to list
    }

}
