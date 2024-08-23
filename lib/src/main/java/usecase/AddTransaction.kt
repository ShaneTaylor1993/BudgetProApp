package usecase

import repository.TransactionRepository
import javax.inject.Inject

class AddTransaction @Inject constructor(
    private val repo: TransactionRepository
) {
    suspend fun addTransaction(type: String, category: String, amount: Float) {
        repo.addTransaction(type, category, amount)
    }
}