package data

import androidx.room.Database
import androidx.room.RoomDatabase
import service.BudgetDao
import service.TransactionDao

@Database(entities = [Transaction::class, Budget::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun budgetDao(): BudgetDao
}