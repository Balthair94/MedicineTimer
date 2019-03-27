package com.baltazar.medicinetimer

import android.content.Context
import com.baltazar.medicinetimer.main.MainPresenter
import com.baltazar.medicinetimer.repository.PreferenceRepository
import com.baltazar.medicinetimer.repository.PreferenceRepositoryImpl
import org.koin.dsl.module.module

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */

fun modulePreference(context: Context) = module{
    single<PreferenceRepository> { PreferenceRepositoryImpl(context) }
    factory { MainPresenter(get()) }
}