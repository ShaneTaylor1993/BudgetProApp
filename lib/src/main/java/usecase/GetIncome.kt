package usecase

import data.Income
import repository.IncomeRepo
import javax.inject.Inject

class GetIncome @Inject constructor(
    private val repo: IncomeRepo
) {
   suspend fun getIncome(): List<Income> {
        return repo.getIncome()
    }
}