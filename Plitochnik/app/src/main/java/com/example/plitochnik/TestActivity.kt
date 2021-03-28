package com.example.plitochnik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.TextView

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        val personName = findViewById<TextView>(R.id.person_name_id_test)
        val mas = intent.getStringExtra("EXTRA_MESSAG")
        personName.setText(mas)
    }
}
