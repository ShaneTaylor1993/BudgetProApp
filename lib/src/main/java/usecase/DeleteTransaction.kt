package usecase

import repository.TransactionRepository
import javax.inject.Inject

class DeleteTransaction @Inject constructor(
    private val repo: TransactionRepository
) {

    suspend fun deleteTransaction(id: Int, type: String, category: String, amount: Float) {
        repo.deleteTransaction(id, type, category, amount)
    }
}