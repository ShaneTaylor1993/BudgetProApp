package service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import data.Income

@Dao
interface IncomeDao {
    @Query("SELECT * FROM income_table")
    suspend fun getIncome(): List<Income>

    @Insert
    suspend fun addIncome(income: Income)

    @Delete
    suspend fun deleteIncome(income: Income)
}