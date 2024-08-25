package usecase

import data.Budget
import repository.BudgetRepository
import util.calculateAmount
import javax.inject.Inject

class UpdateBudget @Inject constructor(
    private val repo: BudgetRepository
) {
    fun updateBudget(operator: String, amount: Int) {
        val value = calculateAmount(operator, amount)
        repo.updateBudget(Budget(
            budget = value
        ))
    }
}