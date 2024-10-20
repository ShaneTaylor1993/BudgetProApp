package repository

import data.Budget
import kotlinx.coroutines.flow.Flow
import service.BudgetDao
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val service: BudgetDao
){
    suspend fun updateBudget(budget: Budget) {
        service.updateBudget(budget)
    }

    fun getBudget(): Flow<Budget?> = service.getBudget()

    suspend fun addBudget(budget: Budget) {
        service.addBudget(budget)
    }
}