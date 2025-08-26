package com.smkth.app4recyclerview

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo: ImageView = findViewById(R.id.logoImage)

        // Animasi masuk (zoom + rotate + slide + fade)
        val scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0f, 1f).apply {
            duration = 1200
            interpolator = OvershootInterpolator()
        }
        val scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0f, 1f).apply {
            duration = 1200
            interpolator = OvershootInterpolator()
        }
        val rotate = ObjectAnimator.ofFloat(logo, "rotation", -30f, 0f).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
        }
        val fadeIn = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f).apply {
            duration = 800
        }
        val slideUp = ObjectAnimator.ofFloat(logo, "translationY", 200f, 0f).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
        }

        // Animasi keluar (fade-out logo)
        val fadeOut = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f).apply {
            duration = 600
            startDelay = 500 // jeda sebentar sebelum keluar
        }

        // Set animasi masuk
        val enterSet = AnimatorSet().apply {
            playTogether(scaleX, scaleY, rotate, fadeIn, slideUp)
        }

        // Gabungkan animasi masuk + keluar
        val fullAnim = AnimatorSet().apply {
            playSequentially(enterSet, fadeOut)
        }

        // Setelah animasi selesai → ke MainActivity
        fullAnim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}
            override fun onAnimationCancel(animation: Animator) {}
            override fun onAnimationRepeat(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        })

        // Mulai animasi
        fullAnim.start()
    }
}
