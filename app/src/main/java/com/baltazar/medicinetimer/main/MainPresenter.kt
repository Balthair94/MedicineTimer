package com.baltazar.medicinetimer.main

import com.baltazar.medicinetimer.repository.PreferenceRepository

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
class MainPresenter(private val mPreferenceRepository: PreferenceRepository): MainContract.Presenter{

    private lateinit var mView: MainContract.View

    override fun init(view: Any) {
        (view as? MainContract.View)?.let {
            mView = it
        }
    }

    override fun dispatchMessage() {
        mView.showMessage(mPreferenceRepository.sayHello())
    }
}