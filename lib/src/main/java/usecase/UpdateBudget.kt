package usecase

import repository.BudgetRepository
import util.calculateAmount
import javax.inject.Inject

class UpdateBudget @Inject constructor(
    private val repo: BudgetRepository
) {
    fun updateBudget(operator: String, amount: Float) {
        val value = calculateAmount(operator, amount)
        repo.updateBudget(value)
    }
}