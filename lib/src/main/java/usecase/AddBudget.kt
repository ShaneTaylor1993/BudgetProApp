package usecase

import data.Budget
import kotlinx.coroutines.flow.Flow
import repository.BudgetRepository
import javax.inject.Inject

class AddBudget @Inject constructor(
    private val repo: BudgetRepository
) {
    suspend operator fun invoke(budget: Budget) {
        return repo.addBudget(budget)
    }
}