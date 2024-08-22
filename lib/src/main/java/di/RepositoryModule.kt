package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import repository.ExpenseRepo
import repository.IncomeRepo
import service.ExpenseDao
import service.IncomeDao
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesIncomeRepo(service: IncomeDao): IncomeRepo {
        return IncomeRepo(service)
    }

    @Singleton
    @Provides
    fun providesExpenseRepo(service: ExpenseDao): ExpenseRepo {
        return ExpenseRepo(service)
    }
}