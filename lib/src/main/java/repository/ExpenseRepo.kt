package repository

import data.Expense
import service.ExpenseDao
import javax.inject.Inject

class ExpenseRepo @Inject constructor(
    private val service: ExpenseDao
) {
    suspend fun getExpenses(): List<Expense> {
        return service.getExpenses()
    }
    suspend fun addExpense(expense: Expense) {
        service.addExpense(expense)
    }
    suspend fun deleteExpense(expense: Expense) {
        service.deleteExpense(expense)
    }
}