package com.example.dados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonD6 = findViewById<Button>(R.id.buttonD6)
        val buttonD12 = findViewById<Button>(R.id.buttonD12)
        val buttonD20 = findViewById<Button>(R.id.buttonD20)

        val intentDados = Intent( this, MainActivity2::class.java)

        buttonD6.setOnClickListener {
            intentDados.putExtra("Lados", 6)
            startActivity(intentDados)
        }
        buttonD12.setOnClickListener {
            intentDados.putExtra("Lados", 12)
            startActivity(intentDados)
        }
        buttonD20.setOnClickListener {
            intentDados.putExtra("Lados", 20)
            startActivity(intentDados)
        }
    }
}
