package usecase

import data.Income
import repository.IncomeRepo
import javax.inject.Inject

class AddIncome @Inject constructor(
    private val repo: IncomeRepo
) {
    suspend fun addIncome(income: Income) {
        repo.addIncome(income)
    }
}