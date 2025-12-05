package com.revature.ExpenseReport.Service;

import com.revature.ExpenseReport.Model.Report;
import com.revature.ExpenseReport.Repository.ReportRepository;
import com.revature.ExpenseReport.Repository.ExpenseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReportService {

    // Fields
    private final ReportRepository repository;
    private final ExpenseRepository expenseRepository;
    private final EntityManager entityManager;

    // Constructor
    public ReportService(ReportRepository repository, ExpenseRepository expenseRepository, EntityManager entityManager) {
        this.repository = repository;
        this.expenseRepository = expenseRepository;
        this.entityManager = entityManager;
    }

    // Methods
    public List<Report> getAllReports() {
        return repository.findAll();
    }

    public Report create(Report report) {
        return repository.save(report);
    }

    public Report getById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Update
    public Report update(String id, Report report) {
        Report existingReport = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existingReport.setReportTitle(report.getReportTitle());
        existingReport.setReportStatus(report.getReportStatus());

        return repository.save(existingReport);
    }

    // Delete
    public void delete(String id) {
        repository.deleteById(id);
    }

    /**
     * Attach an existing expense to a report.
     * This uses a JPQL update so we don't need setters on the Expense model.
     */
    @Transactional
    public Report addExpenseToReport(String reportId, String expenseId) {
        Report report = repository.findById(reportId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Ensure the expense exists
        expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // JPQL update to set the relationship at DB level (avoids needing a setter on Expense)
        int updated = entityManager.createQuery("UPDATE Expense e SET e.report = :report WHERE e.expenseId = :expenseId")
                .setParameter("report", report)
                .setParameter("expenseId", expenseId)
                .executeUpdate();

        if (updated == 0) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to attach expense to report");
        }

        // return fresh report
        return repository.findById(reportId).orElse(report);
    }
}
