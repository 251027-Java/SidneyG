package com.revature.ExpenseReport.Controllers;
import com.revature.ExpenseReport.Model.Expense;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    // Fields
    //Constructor
    //Methods

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();// all if the expenses!
    }

    @GetMapping("/search")
    public List<Expense> search(@RequestParam String merchant) {
        return // all expenses with that merchant name
    }
}
