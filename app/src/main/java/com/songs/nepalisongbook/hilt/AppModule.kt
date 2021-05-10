package com.songs.nepalisongbook.hilt

import com.google.firebase.firestore.FirebaseFirestore
import com.songs.nepalisongbook.repository.DataRepository
import com.songs.nepalisongbook.repository.DataRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
open class AppModule {

    @Singleton
    @Provides
    open fun provideFireStore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    open fun provideDataRepository(db: FirebaseFirestore): DataRepository = DataRepositoryImp(db)
}