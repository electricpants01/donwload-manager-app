package com.example.donwloadmanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.donwloadmanagerapp.databinding.ActivityMainBinding
import com.example.donwloadmanagerapp.download.Downloader
import com.example.donwloadmanagerapp.download.MyDownloader

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var downloader: Downloader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        downloader = MyDownloader(this)
        setButtons()
    }

    private fun setButtons() {
        binding.apply {
            videoButton.setOnClickListener {
                downloader.downloadFile("https://scienceandfilm.org/uploads/videos/files/2030_trailer.mp4",
                    fileName = "2030-trailer.mp4")
            }

            imageButton.setOnClickListener {
                downloader.downloadFile("https://www.usatoday.com/gcdn/authoring/authoring-images/2023/09/19/USAT/70903112007-11-paris-by-emily-emily-coopers-paris.jpg?width=300&height=467&fit=crop&format=pjpg&auto=webp",
                    fileName = "paris.jpg")
            }

            zipButton.setOnClickListener {
                downloader.downloadFile("https://master.dl.sourceforge.net/project/opengapps/arm64/20220215/open_gapps-arm64-9.0-stock-20220215.zip?viasf=1",
                    fileName = "gapps.zip")
            }
        }
    }
}