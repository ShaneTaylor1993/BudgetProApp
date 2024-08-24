package usecase

import data.Transaction
import kotlinx.coroutines.flow.Flow
import repository.TransactionRepository
import javax.inject.Inject

class GetTransactions @Inject constructor(
    private val repo: TransactionRepository
) {
    suspend fun getTransactions(type: String): Flow<List<Transaction>> {
        return repo.getListOfTransactions(type)
    }
}