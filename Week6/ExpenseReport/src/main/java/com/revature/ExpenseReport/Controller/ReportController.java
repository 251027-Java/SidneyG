package com.revature.ExpenseReport.Controller;

import com.revature.ExpenseReport.Model.Report;
import com.revature.ExpenseReport.Service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports") // domain:port/api/reports
public class ReportController {
    // Fields
    private final ReportService service;

    // Constructor
    public ReportController(ReportService service) {
        this.service = service;
    }

    // Methods
    @GetMapping // domain:port/api/reports
    public List<Report> getAllReports() {
        return service.getAllReports();
    }

    // Create a report
    @PostMapping
    public Report create(@RequestBody Report report) {
        return service.create(report);
    }

    // Get report by ID
    @GetMapping("/{id}")
    public Report getById(@PathVariable String id) {
        return service.getById(id);
    }

    // Attach an existing expense to this report
    @PostMapping("/{reportId}/expenses/{expenseId}")
    public Report addExpenseToReport(@PathVariable String reportId, @PathVariable String expenseId) {
        return service.addExpenseToReport(reportId, expenseId);
    }

    // Update/modify a report
    @PutMapping("/{id}")
    public Report update(@PathVariable String id, @RequestBody Report report) {
        return service.update(id, report);
    }

    // Delete a report
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
