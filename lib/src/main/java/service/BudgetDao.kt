package service

import androidx.room.Dao
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {
    @Update
    fun updateBudget(amount: Float): Flow<Float>
}