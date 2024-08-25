package usecase

import data.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import repository.TransactionRepository
import javax.inject.Inject

class GetTransactions @Inject constructor(
    private val repo: TransactionRepository,
) {
    fun getTransactions(type: String): Flow<List<Transaction>> {
            return repo.getListOfTransactions(type)
        }
}