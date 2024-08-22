package repository

import data.Income
import service.IncomeDao
import javax.inject.Inject

class IncomeRepo @Inject constructor(
    private val service: IncomeDao
) {
    suspend fun getIncome(): List<Income> {
        return service.getIncome()
    }
    suspend fun addIncome(income: Income) {
        service.addIncome(income)
    }
    suspend fun deleteIncome(income: Income) {
        return service.deleteIncome(income)
    }
}