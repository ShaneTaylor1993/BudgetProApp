package repository

import data.Expense
import data.Income
import service.ExpenseDao
import service.IncomeDao
import javax.inject.Inject

class IncomeRepo @Inject constructor(
    private val service: IncomeDao
) {
    suspend fun getIncome(): List<Income> {
        return service.getIncome()
    }
}