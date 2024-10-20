package usecase

import data.Budget
import repository.BudgetRepository
import util.calculateAmount
import javax.inject.Inject

class UpdateBudget @Inject constructor(
    private val repo: BudgetRepository
) {
    suspend fun updateBudget(operator: String, transactionAmount: Int, budgetAmount: Int) {
        val value = calculateAmount(operator, transactionAmount, budgetAmount)
        repo.updateBudget(
            Budget(id = 1, amount = value)
        )
    }
}