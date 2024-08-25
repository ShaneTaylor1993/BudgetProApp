package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.Budget
import data.Database
import service.BudgetDao
import service.TransactionDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun providesDatabase(@ApplicationContext applicationContext: Context): Database {
        return Room.databaseBuilder(
            applicationContext,
            Database::class.java, "Database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(appDatabase: Database): TransactionDao {
        return appDatabase.transactionDao()
    }
    @Provides
    @Singleton
    fun provideBudgetDao(appDatabase: Database): BudgetDao {
        return appDatabase.budgetDao()
    }
}