package com.example.app_11010145

import android.content.DialogInterface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.app_11010145.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        //C:/tmp/video.mp4
        val uri ="android.resource://"+packageName+"/"+R.raw.cat
        binding.videoView.setVideoURI(Uri.parse(uri))

        //binding.videoView.start()

        binding.btnPlay.setOnClickListener(myClick)
        binding.btnPause.setOnClickListener(myClick)
        binding.btnStop.setOnClickListener(myClick)
        //binding.btnNote.setOnClickListener(myClick)

        binding.btnNote.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.dialogTitle)
                .setMessage(R.string.dialogMessage)
                .setPositiveButton("OK",DialogInterface.OnClickListener {dialog,which->
                    Toast.makeText(this@MainActivity,"確定",Toast.LENGTH_LONG).show()
                })
                .setNegativeButton("cancel",DialogInterface.OnClickListener {dialog,which->
                    finish() //結束程式
                })
                .show()
        }

    }

    private val myClick=View.OnClickListener {
        //Log.d("myTag","it："+it.id)
        when(it.id){
            R.id.btnPlay ->{
                binding.videoView.start()
            }
            R.id.btnPause ->{
                binding.videoView.pause()
            }
            R.id.btnStop ->{
                binding.videoView.stopPlayback()
            }
        }
    }
}

