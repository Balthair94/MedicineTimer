package com.baltazar.medicinetimer.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.baltazar.medicinetimer.R
import com.baltazar.medicinetimer.util.bindView
import com.baltazar.medicinetimer.util.showToast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    private val mButtonAction: Button? by bindView(R.id.button_action)
    private val mButtonAddHours: ImageButton? by bindView(R.id.button_add_hours)
    private val mButtonRemoveHours: ImageButton? by bindView(R.id.button_remove_hours)
    private val mButtonAddMinutes: ImageButton? by bindView(R.id.button_add_minutes)
    private val mButtonRemoveMinutes: ImageButton? by bindView(R.id.button_remove_minutes)

    private val mTextHours: TextView? by bindView(R.id.text_hours)
    private val mTextMinutes: TextView? by bindView(R.id.text_minutes)
    private val mTextSeconds: TextView? by bindView(R.id.text_seconds)

    private val mPresenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.init(this)
        setupWidgets()
    }

    override fun showMessage(message: String) {
        showToast(message)
    }

    private fun setupWidgets() {
        mButtonAction?.setOnClickListener { mPresenter.dispatchMessage() }
    }
}
