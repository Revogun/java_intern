package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    @GetMapping
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    // Add expense
    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    // Update expense
    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        expense.setId(id);
        return expenseRepository.save(expense);
    }
    @GetMapping("/monthly")
    public List<Expense> getMonthlyExpenses(
            @RequestParam Long userId,
            @RequestParam int year,
            @RequestParam int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        return expenseRepository.findByUserIdAndDateBetween(userId, start, end);
    }


    // Delete expense
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }
}


