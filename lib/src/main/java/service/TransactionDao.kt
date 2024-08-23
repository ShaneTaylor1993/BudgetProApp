package service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.Transaction

@Dao
interface TransactionDao {
    @Query("SELECT transaction_category FROM transaction_table WHERE transaction_category = 'income'")
    suspend fun getIncome(): List<Transaction>

    @Insert
    suspend fun addExpense(expense: Transaction)

    @Delete
    suspend fun deleteExpense(expense: Transaction)
}