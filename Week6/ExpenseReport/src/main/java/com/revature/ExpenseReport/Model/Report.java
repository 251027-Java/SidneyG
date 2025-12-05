package com.revature.ExpenseReport.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor

public class Report {
    // Fields

    @Id @GeneratedValue
    private String reportId;
    private String reportTitle;
    private String reportStatus;


    @OneToMany(mappedBy = "report")
    @JsonManagedReference
    private List<Expense> reportExpenses = new ArrayList<>();

    //Constructor
    public Report (String title, String status){
        this.reportTitle = title;
        this.reportStatus = status;
    }

    // helper to attach an existing expense
    public void addExpense(Expense expense) {
        if (expense == null) return;
        this.reportExpenses.add(expense);
    }

    // Methods


}
