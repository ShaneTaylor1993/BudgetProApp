package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import repository.BudgetRepository
import repository.TransactionRepository
import service.BudgetDao
import service.TransactionDao
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
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