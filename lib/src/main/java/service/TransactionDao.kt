package service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.Transaction

@Dao
interface TransactionDao {
    @Query("SELECT transaction_category FROM transaction_table WHERE transaction_type = :type")
    suspend fun getListByType(type: String): List<Transaction>

    @Insert
    suspend fun addTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}