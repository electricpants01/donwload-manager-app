package com.example.donwloadmanagerapp.download

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DownloadCompletedReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context?, intent: Intent?) {
        if(intent?.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra("extra_download_id", -1)
            if (id != -1L) {
                println("Download with ID $id completed!")
                Toast.makeText(p0, "Download with ID $id completed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
