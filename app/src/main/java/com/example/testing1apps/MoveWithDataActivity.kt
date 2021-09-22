package com.example.testing1apps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_Result="extra_result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        var result:TextView = findViewById(R.id.result)
        val calresult= intent.getDoubleExtra(EXTRA_Result,0.0)
        val text = "count result : $calresult"
        result.text=text
    }
}