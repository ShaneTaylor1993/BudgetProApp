package service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense_table")
    suspend fun getExpenses(): List<Expense>

    @Insert
    suspend fun addExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)
}