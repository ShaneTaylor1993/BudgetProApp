package usecase

import data.Budget
import kotlinx.coroutines.flow.Flow
import repository.BudgetRepository
import util.calculateAmount
import javax.inject.Inject

class GetBudget @Inject constructor(
    private val repo: BudgetRepository
) {
    fun getBudget(): Flow<Budget?> {
        return repo.getBudget()
    }
}