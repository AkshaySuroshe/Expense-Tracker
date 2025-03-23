package com.expenseTracker.service;

import java.util.List;

import com.expenseTracker.model.Expense;

public interface IExpenseService {

	Expense saveExpense(Expense expense);

	Expense updateExpense(int id,Expense expense);

	List<Expense> getExpensesOfUser(int userId);

	List<Expense> getDateWiseExpense(int userId, String date);

	List<Expense> getCategoryWise(int userId, String category);

}
