package com.expenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.model.Expense;
import com.expenseTracker.service.IExpenseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	IExpenseService expenseService;

//save	
	@PostMapping("/save")
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense)
	{
		Expense savedExpense = expenseService.saveExpense(expense);
		return new ResponseEntity<Expense>(savedExpense,HttpStatus.OK);
	}//
	
//edit
	@PutMapping("/update/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable int id,@RequestBody Expense expense)
	{
		Expense updatedExpense = expenseService.updateExpense(id,expense);
		return new ResponseEntity<Expense>(updatedExpense,HttpStatus.OK);
	}//
//get Expenses By UserId
	@GetMapping("/getUserId/{userId}")
	public ResponseEntity<List<Expense>> getExpensesOfUser(@PathVariable int userId)
	{
		List<Expense> expensesOfUser= expenseService.getExpensesOfUser(userId);
		return new ResponseEntity<List<Expense>>(expensesOfUser,HttpStatus.OK);
	}//
// get Expense Date Wise
	@GetMapping("/month/{userId}/{date}")
	public ResponseEntity<List<Expense>> getDateWise(@PathVariable int userId,@PathVariable String date)
	{
		List<Expense> dateWiseExpenses=expenseService.getDateWiseExpense(userId,date);
		return new ResponseEntity<List<Expense>>(dateWiseExpenses,HttpStatus.OK);
	}//
//get expenses by category wise
	@GetMapping("/category/{userId}/{category}")
	public ResponseEntity<List<Expense>> getCategoryWise(@PathVariable int userId,@PathVariable String category)
	{
		List<Expense> categoryWiseExpenses=expenseService.getCategoryWise(userId,category);
		return new ResponseEntity<List<Expense>>(categoryWiseExpenses,HttpStatus.OK);
	}//
}//class
