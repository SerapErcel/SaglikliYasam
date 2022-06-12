package com.serapercel.saglikliyasam.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.serapercel.saglikliyasam.R
import java.util.concurrent.TimeUnit

fun Context.toastShort(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun ImageView.downloadImage(url: String?, placeholder: CircularProgressDrawable) {
    val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}

fun placeHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

fun createWorkRequest(message: String, timeDelay: Long, context: Context) {
    val myWorkRequest = PeriodicWorkRequestBuilder<ReminderWorker>(timeDelay, TimeUnit.MINUTES)
        .setInputData(
            workDataOf(
                "title" to "Sağlıklı Yaşam",
                "message" to message,
            )
        )
        .build()

    WorkManager.getInstance(context).enqueue(myWorkRequest)

}
