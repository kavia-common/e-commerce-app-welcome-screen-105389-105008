package org.example.app

import android.widget.TextView
import android.os.Bundle
import android.app.Activity

// PUBLIC_INTERFACE
/**
 * MainActivity is the main activity of the e-commerce application.
 * It is launched after the splash screen and displays the main app content.
 */
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById(R.id.textView) as TextView
        textView.text = getString(R.string.welcome_message)
    }
}
