package com.example.expensetrackerproject.repository;

import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(Users user);

    List<Expense> findExpenseByUserId(Long userId);
}
