package usecase

import data.Expense
import repository.ExpenseRepo
import javax.inject.Inject

class AddExpense @Inject constructor(
    private val repo: ExpenseRepo
) {
    suspend fun addExpense(expense: Expense) {
        repo.addExpense(expense)
    }
}