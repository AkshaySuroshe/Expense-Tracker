package com.expenseTracker.repo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseTracker.model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {

	List<Budget> findByUserId(int userId);

	List<Budget> findByUserIdAndCategory(int userId, String category);

}//
