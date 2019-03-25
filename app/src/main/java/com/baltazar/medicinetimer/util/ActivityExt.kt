package com.baltazar.medicinetimer.util

import android.app.Activity
import android.widget.Toast

/**
 * Created by Baltazar Rodriguez Ramirez on 3/24/19.
 */

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}