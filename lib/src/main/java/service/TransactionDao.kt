package service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

@Dao
interface TransactionDao {
    @Query("SELECT * FROM transaction_table WHERE transaction_type = :type")
    fun getListByType(type: String): Flow<List<Transaction>>

    @Insert
    suspend fun addTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)
}