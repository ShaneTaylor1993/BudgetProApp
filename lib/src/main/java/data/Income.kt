package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "income_table")
data class Income(
    @PrimaryKey val id: Int = Random.nextInt(),
    @ColumnInfo(name = "expense_name") val expenseName: String?,
    @ColumnInfo(name = "expense_amount") val expenseAmount: Float?,
)
