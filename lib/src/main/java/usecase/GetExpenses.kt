package usecase

import data.Expense
import data.Income
import repository.ExpenseRepo
import repository.IncomeRepo
import javax.inject.Inject

class GetExpenses @Inject constructor(
    private val repo: ExpenseRepo
) {
    suspend fun getExpenses(): List<Expense> {
        return repo.getExpenses()
    }
}