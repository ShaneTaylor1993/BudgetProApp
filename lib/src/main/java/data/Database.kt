package data

import androidx.room.Database
import androidx.room.RoomDatabase
import service.ExpenseDao
import service.IncomeDao

@Database(entities = [Income::class, Expense::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun incomeDao(): IncomeDao
    abstract fun expenseDao(): ExpenseDao
}