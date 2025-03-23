package com.expenseTracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.model.Budget;
import com.expenseTracker.repo.BudgetRepository;

@Service
public class BudgetService implements IBudgetService
{
	@Autowired
	BudgetRepository budgetRepository;
	
	@Override
	public Budget setNewBudget(Budget budget) {
		budget.setStartDate(budget.getStartDate() );
		budget.setEndDate(budget.getEndDate());
		
		// If they are not null, proceed to save
	    if (budget.getStartDate() != null && budget.getEndDate() != null) {
	        return budgetRepository.save(budget);
	    } else {
	        throw new IllegalArgumentException("Start Date or End Date is null");
	    }
	}//

	@Override
	public List<Budget> getBudgetsForUsers() {
		// TODO Auto-generated method stub
		return null;
	}//

	@Override
	public List<Budget> getBudgetsForUsers(int userId) {
		 List<Budget> budgets= budgetRepository.findByUserId(userId);
		return budgets;
	}//

	@Override
	public List<Budget> getCategoryWiseBudget(int userId, String category) {
		List<Budget> categoryBudgets= budgetRepository.findByUserIdAndCategory(userId,category);
		return categoryBudgets;
	}

	@Override
	public Budget deleteBudget(int id) {
		budgetRepository.deleteById(id);
		return null;
	}

}//class
