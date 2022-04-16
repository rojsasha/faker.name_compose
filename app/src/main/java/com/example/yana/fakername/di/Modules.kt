package com.example.yana.fakername.di

import androidx.room.Room
import com.example.yana.fakername.db.FakerAppDataBase
import com.example.yana.fakername.network.FakerIteractor
import com.example.yana.fakername.network.FakerIteractorImpl
import com.example.yana.fakername.network.RetrofitFaker
import com.example.yana.fakername.repository.FakerRepository
import com.example.yana.fakername.repository.FakerRepositoryImpl
import com.example.yana.fakername.fragmentsViewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


val fakerModules by lazy {
    loadKoinModules(
        listOf(
            networkModule,
            viewModelModule,
            iteractorModules,
            dbModule,
//            utilsModule,
            repositoryModel
        )
    )
}

val networkModule = module {
    single {
        RetrofitFaker.buildRetrofit()
    }
}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
val iteractorModules = module {
    single<FakerIteractor> { FakerIteractorImpl(get()) }
}
val repositoryModel = module {
    single <FakerRepository> { FakerRepositoryImpl(get(), get()) }
}
val dbModule = module {
    single { Room.databaseBuilder(get(), FakerAppDataBase::class.java,"fakerName")
        .allowMainThreadQueries()
        .build()
    }
    single { get<FakerAppDataBase>().getFakerDao()}
}