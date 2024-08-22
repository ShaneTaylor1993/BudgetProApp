package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income_table")
data class Income(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "expense_name") val expenseName: String?,
    @ColumnInfo(name = "expense_amount") val expenseAmount: Float?,
)