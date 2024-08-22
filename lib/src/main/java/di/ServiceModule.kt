package di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import data.Database

@Module
@InstallIn(ActivityComponent::class)
class ServiceModule {

    @Provides
    fun providesDatabase(applicationContext: Context): Database {
        return Room.databaseBuilder(
            applicationContext,
            Database::class.java, "Database"
        ).build()
    }
}