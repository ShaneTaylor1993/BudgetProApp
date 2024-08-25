package service

import androidx.room.Dao
import androidx.room.Update
import data.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Update
    fun updateBudget(budget: Budget): Int
}