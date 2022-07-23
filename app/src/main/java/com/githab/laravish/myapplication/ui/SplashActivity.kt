package com.githab.laravish.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.githab.laravish.myapplication.MainActivity
import com.githab.laravish.myapplication.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val handler = Handler(Looper.getMainLooper())
    private val delay = 3000L
    private val rotateValue = 750f
    private val interpolatorDuration = 10000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, delay)

        binding.imageView.animate().rotationBy(rotateValue)
            .setInterpolator(LinearInterpolator()).duration = interpolatorDuration
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}