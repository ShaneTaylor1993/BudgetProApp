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
}