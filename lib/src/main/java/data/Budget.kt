package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budget_table")
data class Budget(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "budget_amount") val budget: Float
)
