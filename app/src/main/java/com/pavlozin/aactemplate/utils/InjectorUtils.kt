package com.pavlozin.aactemplate.utils

import android.content.Context
import com.pavlozin.aactemplate.data.AppDatabase
import com.pavlozin.aactemplate.data.MainRepository
import com.pavlozin.aactemplate.viewmodels.MainViewModelFactory

object InjectorUtils {

    private fun getRepository(context: Context) : MainRepository {
        return MainRepository.getInstance(AppDatabase.getInstance(context.applicationContext).getMainDao())
    }

    fun provideMainViewModelFactory(context: Context) : MainViewModelFactory {
        val repository = getRepository(context)
        return MainViewModelFactory(repository)
    }
}