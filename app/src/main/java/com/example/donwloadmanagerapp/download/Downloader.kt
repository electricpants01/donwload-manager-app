package com.example.donwloadmanagerapp.download

interface Downloader {
    fun downloadFile(url: String, fileName: String): Long
}