package repository

import service.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val service: BudgetDao
){
    fun updateBudget(amount: Float) {
        service.updateBudget(amount)
    }
}