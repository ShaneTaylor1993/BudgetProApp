package usecase

import data.Expense
import repository.ExpenseRepo
import javax.inject.Inject

class DeleteExpense @Inject constructor(
    private val repo: ExpenseRepo
) {
    suspend fun deleteExpense(expense: Expense) {
        repo.deleteExpense(expense)
    }
}