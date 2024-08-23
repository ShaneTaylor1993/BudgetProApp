package repository

import data.Transaction
import service.TransactionDao
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val service: TransactionDao
) {
    suspend fun getListOfTransactions(type: String) {
        service.getListByType(type)
    }

    suspend fun addTransaction(type: String, category: String, amount: Float ) {
        service.addTransaction(Transaction(
            transactionType = type,
            transactionCategory = category,
            transactionAmount = amount
        ))
    }
}