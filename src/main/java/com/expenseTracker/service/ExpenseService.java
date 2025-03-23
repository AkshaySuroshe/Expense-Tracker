package com.expenseTracker.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.exceptions.Exceptions;
import com.expenseTracker.model.Expense;
import com.expenseTracker.repo.ExpenseRepository;

@Service
public class ExpenseService implements IExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;
	
	LocalTime localTime=	LocalTime.now();// for current time
	LocalDate localDate = LocalDate.now();// for current date

//save	
	@Override
	public Expense saveExpense(Expense expense) {
		expense.setDate(localDate);
		expense.setTime(localTime);
		Expense save = expenseRepository.save(expense);
		return save;
	}//

//update	
	@Override
	public Expense updateExpense(int id,Expense expense) {
		Optional<Expense> expenseCheck = expenseRepository.findById(id);
		if(expenseCheck.isPresent()) {
			Expense expensePresent = expenseCheck.get();
			
			expensePresent.setUserId(expense.getUserId());
			expensePresent.setCategory(expense.getCategory());
			expensePresent.setSubcategory(expense.getSubcategory());
			expensePresent.setDescription(expense.getDescription());
			expensePresent.setAmount(expense.getAmount());
			expensePresent.setDate(localDate);
			expensePresent.setTime(localTime);
			
		return	expenseRepository.save(expensePresent);
			
		}//if
		else {
			
			throw new Exceptions("Expense not Found");
		}
	
	}//

//get Expenses of User	
	@Override
	public List<Expense> getExpensesOfUser(int userId) {
		List<Expense> expenseOfUser = expenseRepository.findByUserId(userId);
		if(expenseOfUser !=null)
		{
			return expenseOfUser;
		}
		else {
			throw new Exceptions("Expenses Not Found By "+userId);
		}
	}

//get date wise expenses of user	
	@Override
	public List<Expense> getDateWiseExpense(int userId, String date) {
		LocalDate datee = LocalDate.parse(date); //we need to parse this 
		List<Expense> dateWiseExpenses =	expenseRepository.findByUserIdAndDate(userId,datee);
		return dateWiseExpenses;
	}//

//get category Wise Expenses	
	@Override
	public List<Expense> getCategoryWise(int userId, String category) {
		List<Expense> categoryWiseExpenses= expenseRepository.findByUserIdAndCategory(userId,category);		
		return categoryWiseExpenses;
	}

}//class..
