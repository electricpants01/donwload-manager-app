package com.example.donwloadmanagerapp.download

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import java.util.Date

class MyDownloader(
    context: Context
): Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String, fileName: String): Long {
        val time = Date().time.toString()
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("*/*")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("downloading:  $fileName")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$time-$fileName")
        return downloadManager.enqueue(request)
    }
}