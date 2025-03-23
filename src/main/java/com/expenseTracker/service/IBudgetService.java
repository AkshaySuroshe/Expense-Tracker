package com.expenseTracker.service;

import java.util.List;

import com.expenseTracker.model.Budget;

public interface IBudgetService {

	Budget setNewBudget(Budget budget);
	List<Budget> getBudgetsForUsers();
	List<Budget> getBudgetsForUsers(int userId);
	List<Budget> getCategoryWiseBudget(int userId, String category);
	Budget deleteBudget(int id);

}//
