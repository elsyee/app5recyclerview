package com.smkth.app4recyclerview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo: ImageView = findViewById(R.id.logoImage)

        // Zoom in dengan bounce
        val scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1.2f, 1f)
        val scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1.2f, 1f)
        scaleX.interpolator = BounceInterpolator()
        scaleY.interpolator = BounceInterpolator()
        scaleX.duration = 1500
        scaleY.duration = 1500

        // Fade in
        val fadeIn = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f)
        fadeIn.duration = 1000

        // Rotate dari miring
        val rotate = ObjectAnimator.ofFloat(logo, "rotation", -45f, 0f)
        rotate.duration = 1200
        rotate.interpolator = AccelerateDecelerateInterpolator()

        // Geser dari bawah
        val translateY = ObjectAnimator.ofFloat(logo, "translationY", 200f, 0f)
        translateY.duration = 1200
        translateY.interpolator = AccelerateDecelerateInterpolator()

        // Gabungkan animasi
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY, fadeIn, rotate, translateY)
        animatorSet.start()

        // Pindah ke MainActivity setelah 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 2000)
    }
}


