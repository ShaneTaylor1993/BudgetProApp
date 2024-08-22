package usecase

import data.Income
import repository.IncomeRepo
import javax.inject.Inject

class DeleteIncome @Inject constructor(
    private val repo: IncomeRepo
) {
    suspend fun deleteIncome(income: Income) {
        repo.deleteIncome(income)
    }
}