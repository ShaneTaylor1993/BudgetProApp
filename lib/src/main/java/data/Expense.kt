package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "expense_table")
data class Expense(
    @PrimaryKey val id: Int = Random.nextInt(),
    @ColumnInfo(name = "expense_name") val expenseName: String?,
    @ColumnInfo(name = "expense_amount") val expenseAmount: Float?,
)
