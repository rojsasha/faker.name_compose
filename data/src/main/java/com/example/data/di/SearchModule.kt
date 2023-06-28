package com.example.data.di

import com.example.data.posts.remote.SearchDataSource
import com.example.data.posts.remote.SearchDataSourceImpl
import com.example.data.posts.repository.PostsRepository
import com.example.data.posts.repository.PostsRepositoryImpl
import com.example.data.remote.FakerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class SearchModule {

    @Provides
    fun provideSearchDataSource(api: FakerApi): SearchDataSource =
        SearchDataSourceImpl(api)

    @Provides
    fun providePostsRepository(datasource : SearchDataSource): PostsRepository =
        PostsRepositoryImpl(datasource)
}


