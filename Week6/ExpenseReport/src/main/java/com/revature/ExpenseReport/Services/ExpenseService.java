package com.revature.ExpenseReport.Services;

import com.revature.ExpenseReport.Model.Expense;
import com.revature.ExpenseReport.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpenseService {
    // Fields
    private final ExpenseRepository repository;

    // Constructor
    public ExpenseService (ExpenseRepository Repository){
        this.repository = Repository;
    }

    // Methods
    public List<Expense> getAllExpenses(){
        return repository.findAll();
    }

    public List<Expense> searchByMerchant(String merchant){
        return repository.findByMerchant(merchant);
    }
}
