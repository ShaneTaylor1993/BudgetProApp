package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import repository.TransactionRepository
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
}