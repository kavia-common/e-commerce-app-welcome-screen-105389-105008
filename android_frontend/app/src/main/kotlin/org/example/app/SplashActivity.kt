package org.example.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.ProgressBar

// PUBLIC_INTERFACE
/**
 * SplashActivity displays the e-commerce app splash screen with animations
 * and transitions to the main activity after a delay.
 */
class SplashActivity : Activity() {
    
    private val splashTimeOut: Long = 3000 // 3 seconds
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        initializeViews()
        startAnimations()
        scheduleTransition()
    }
    
    /**
     * Initialize all views and set up initial states
     */
    private fun initializeViews() {
        // Views are already defined in the layout
        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.app_name)
        val tagline = findViewById<TextView>(R.id.tagline)
        val loadingIndicator = findViewById<ProgressBar>(R.id.loading_indicator)
        val loadingText = findViewById<TextView>(R.id.loading_text)
        
        // Set initial alpha for fade-in effect
        logo.alpha = 0f
        appName.alpha = 0f
        tagline.alpha = 0f
        loadingIndicator.alpha = 0f
        loadingText.alpha = 0f
    }
    
    /**
     * Start all animations for splash screen elements
     */
    private fun startAnimations() {
        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.app_name)
        val tagline = findViewById<TextView>(R.id.tagline)
        val loadingIndicator = findViewById<ProgressBar>(R.id.loading_indicator)
        val loadingText = findViewById<TextView>(R.id.loading_text)
        
        // Load animations
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        
        // Animate logo with scale and fade
        Handler(Looper.getMainLooper()).postDelayed({
            logo.alpha = 1f
            logo.startAnimation(scaleUp)
        }, 200)
        
        // Animate app name
        Handler(Looper.getMainLooper()).postDelayed({
            appName.alpha = 1f
            appName.startAnimation(fadeIn)
        }, 800)
        
        // Animate tagline
        Handler(Looper.getMainLooper()).postDelayed({
            tagline.alpha = 1f
            tagline.startAnimation(slideUp)
        }, 1200)
        
        // Show loading indicator
        Handler(Looper.getMainLooper()).postDelayed({
            loadingIndicator.alpha = 1f
            loadingIndicator.startAnimation(fadeIn)
        }, 1800)
        
        // Show loading text
        Handler(Looper.getMainLooper()).postDelayed({
            loadingText.alpha = 1f
            loadingText.startAnimation(fadeIn)
        }, 2000)
    }
    
    /**
     * Schedule transition to main activity
     */
    private fun scheduleTransition() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
            
            // Add transition animation (suppress deprecation for compatibility)
            @Suppress("DEPRECATION")
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, splashTimeOut)
    }
    
    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        // Disable back button during splash
        // User should not be able to go back from splash screen
    }
}
