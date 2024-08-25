package repository

import data.Budget
import service.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val service: BudgetDao
){
    fun updateBudget(budget: Budget) {
        service.updateBudget(budget)
    }
}