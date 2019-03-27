package com.baltazar.medicinetimer

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.baltazar.medicinetimer.util.makeStatusNotification
import java.util.Date

/**
 * Created by Baltazar Rodriguez Ramirez on 3/26/19.
 */
class TimerWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        val sharePreferenceManager = SharePreferenceManager.init(applicationContext)
        val timeLeft = sharePreferenceManager.getTimeLeft()

        // We could get it from SharePreferences but we did this to test how to pass data to the worker
        val timeToReduce = inputData.getLong(SharePreferenceManager.TIME_TO_REDUCE, 0)

        return try {
            if (timeLeft <= 0) {
                sharePreferenceManager.cleanPreferences()
                makeStatusNotification("Time is over. Take your medicine", applicationContext)
            } else {
                val date = Date(System.currentTimeMillis())
                sharePreferenceManager.saveWorkerLastExecution(date.time)
                sharePreferenceManager.removeSeconds(timeToReduce)
            }
            Result.success()
        } catch (error: Throwable) {
            Result.failure()
        }
    }

    companion object {
        const val TAG = "TimeWorker"
    }
}