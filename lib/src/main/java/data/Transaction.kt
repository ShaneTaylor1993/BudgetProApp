package data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "transaction_table")
data class Transaction(
    @PrimaryKey val id: Int = Random.nextInt(),
    @ColumnInfo(name = "transaction_type") val transactionType: String?,
    @ColumnInfo(name = "transaction_category") val transactionCategory: String?,
    @ColumnInfo(name = "transaction_amount") val transactionAmount: Float?
)
