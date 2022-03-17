package com.example.dados

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonD6 = findViewById<Button>(R.id.btnD6)
        val buttonD12 = findViewById<Button>(R.id.btnD12)
        val buttonD20 = findViewById<Button>(R.id.btnD20)


        buttonD6.setOnClickListener {
            rolarDados(6)
        }

        buttonD12.setOnClickListener {
            rolarDados(12)


        }
        buttonD20.setOnClickListener {
            rolarDados(20)

        }
    }
    fun rolarDados(lados: Int) {

        val valor = (1..lados).random()

        val textResultado = findViewById<TextView>(R.id.textoResultado)

        textResultado.text = valor.toString()
    }

}
