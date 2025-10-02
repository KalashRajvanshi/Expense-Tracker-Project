package com.example.expensetrackerproject.repository;

import com.example.expensetrackerproject.DTO.ModeOfPaymentReport;
import com.example.expensetrackerproject.model.Expense;
import com.example.expensetrackerproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(Users user);

    List<Expense> findExpenseByUserId(Long userId);

//    @Query("SELECT new com.example.expensetrackerproject.DTO.ModeOfPaymentReport(e.modeOfPayment, COUNT(e)) FROM Expense e where GROUP BY e.modeOfPayment")
//    List<ModeOfPaymentReport> SpendByModeOfPayment();

    @Query("SELECT new com.example.expensetrackerproject.DTO.ModeOfPaymentReport(e.modeOfPayment, SUM(e.amount)) " +
            "FROM Expense e WHERE e.user.id = :userId GROUP BY e.modeOfPayment")
    List<ModeOfPaymentReport> SpendByModeOfPayment(@Param("userId") Long userId);
}

