package com.expenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.model.Budget;
import com.expenseTracker.service.IBudgetService;

@RestController
@CrossOrigin("*")
@RequestMapping("/budget")
public class BudgetController {

	@Autowired
	IBudgetService budgetService;
	
	
	
//save budget 
	@PostMapping("/save")
	public ResponseEntity<Budget> setNewBudget(@RequestBody Budget budget)
	{
		Budget setBudget = budgetService.setNewBudget(budget);
		System.out.println(budget.getStartDate());
		System.out.println(budget.getEndDate());
		return new ResponseEntity<Budget>(setBudget,HttpStatus.OK);
	}//
	
//get budget for the user
	@GetMapping("/getBudgets/{userId}")
	public ResponseEntity<List<Budget>> getBudgetsForUser(@PathVariable int userId)
	{
		List<Budget> setBudget= budgetService.getBudgetsForUsers(userId);
		return new ResponseEntity<List<Budget>>(setBudget,HttpStatus.OK);
	}//

//category wise budget	
	@GetMapping("/getBudgetsCat/{userId}/{category}")
	public ResponseEntity<List<Budget>> getCategoryEntityWise(@PathVariable int userId,
																												@PathVariable String category)
	{
		List<Budget> getCategoryWise= budgetService.getCategoryWiseBudget(userId,category);
		return new ResponseEntity<List<Budget>>(getCategoryWise,HttpStatus.OK);
	}//
	
//Delete budget
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Budget> deleteBudget(@PathVariable int id)
	{
		Budget deletedBudget= budgetService.deleteBudget(id);
		return new ResponseEntity<Budget>(deletedBudget,HttpStatus.OK);
	}//
	
}//class
