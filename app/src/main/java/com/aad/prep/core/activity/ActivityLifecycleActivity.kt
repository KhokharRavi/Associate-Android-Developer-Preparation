package com.aad.prep.core.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.aad.prep.R

class ActivityLifecycleActivity : AppCompatActivity() {

    var textViewState: AppCompatTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        showStateMessage("onCreate() called")
        initViews()
    }

    private fun initViews() {
        // set toolbar  title
        val textViewTitle: AppCompatTextView = findViewById(R.id.textViewTitle)
        textViewTitle.text = resources.getString(R.string.activity_lifecycle)

        // set image view back click
        val imageViewBack: AppCompatImageView = findViewById(R.id.imageViewBack)
        imageViewBack.setOnClickListener {
            onBackPressed()
        }

        textViewState = findViewById<AppCompatTextView>(R.id.textViewState)
    }

    override fun onStart() {
        super.onStart()
        showStateMessage("onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        showStateMessage("onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        showStateMessage("onResume() called")
    }

    override fun onPause() {
        super.onPause()
        showStateMessage("onPause() called")

    }

    override fun onStop() {
        super.onStop()
        showStateMessage("onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        showStateMessage("onDestroy() called")
    }

    private fun showStateMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        textViewState?.text = message
    }
}