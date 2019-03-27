package com.baltazar.medicinetimer.main

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
interface MainContract {

    interface View {

        fun showMessage(message: String)
    }

    interface Presenter {

        fun init(view: Any)

        fun dispatchMessage()
    }
}