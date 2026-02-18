package com.example.expense_tracker.service;

import com.example.expense_tracker.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private List<Expense> expenseList = new ArrayList<>();

    public List<Expense> getAll() {
        return expenseList;
    }

    public Expense addExpense(Expense expense) {
        expenseList.add(expense);
        return expense;
    }
}
