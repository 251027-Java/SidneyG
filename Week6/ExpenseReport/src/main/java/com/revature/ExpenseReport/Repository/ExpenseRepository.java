package com.revature.ExpenseReport.Repository;

import com.revature.ExpenseReport.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findByMerchant(String merchant);


}
