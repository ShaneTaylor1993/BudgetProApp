package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import repository.BudgetRepository
import repository.TransactionRepository
import service.BudgetDao
import service.TransactionDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesTransactionRepository(service: TransactionDao): TransactionRepository {
        return TransactionRepository(service)
    }
    @Singleton
    @Provides
    fun providesBudgetRepository(service: BudgetDao): BudgetRepository{
        return BudgetRepository(service)
    }
}