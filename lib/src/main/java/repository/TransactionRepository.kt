package repository

import data.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import service.TransactionDao
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val service: TransactionDao
) {
    fun getListOfTransactions(type: String): Flow<List<Transaction>> {
        return service.getListByType(type)
    }

    suspend fun addTransaction(type: String?, category: String?, amount: Float?) {
        service.addTransaction(
            Transaction(
                transactionType = type,
                transactionCategory = category,
                transactionAmount = amount
            )
        )
    }

    suspend fun deleteTransaction(id: Int, type: String, category: String, amount: Float) {
        service.deleteTransaction(
            Transaction(
                id = id,
                transactionType = type,
                transactionCategory = category,
                transactionAmount = amount
            )
        )
    }
}