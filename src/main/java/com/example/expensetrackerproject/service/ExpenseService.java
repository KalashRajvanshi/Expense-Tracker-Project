package com.example.expensetrackerproject.service;

import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.model.Users;
import com.example.expensetrackerproject.repository.ExpenseRepository;
import com.example.expensetrackerproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final UserRepository usersRepository;
    private final ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        // Logic to add an expense

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Users user = usersRepository.findByUsername(username);
        expense.setUser(user);

        if (expense.getDate() == null) {
            expense.setDate(LocalDate.now());
        }
        System.out.println("Adding expense for user: " + username + ", Expense: " + expense.getDescription() + ", Amount: " + expense.getAmount());
        return expenseRepository.save(expense);

    }

    public List<Expense> getAllExpensesForSpecificUser() {
        // Logic to retrieve all expenses for a specific user

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if(username == null) {
            System.out.println("Username is null, cannot fetch expenses.");
            return null;
        }

        long userId = usersRepository.findByUsername(username).getId();

        List<Expense> listexpenses = expenseRepository.findExpenseByUserId(userId);

        // Fetch user by username
        // Users user = usersRepository.findByUsername(username);

        // Fetch expenses for the user
        // return expenseRepository.findByUser(user);
        return listexpenses;

    }
}
