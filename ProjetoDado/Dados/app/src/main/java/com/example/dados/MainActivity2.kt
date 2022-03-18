package com.example.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


       val lados = intent.getIntExtra("Lados", 0)

        val textDado = findViewById<TextView>(R.id.textDado)
        val buttonRolar = findViewById<Button>(R.id.buttonRodar)

        textDado.text = "D$lados"
        buttonRolar.setOnClickListener {
        rolarDados(lados)
        }

    }
    private fun rolarDados(lados: Int){

        val valor = (1..lados).random()

        val textResultado =  findViewById<TextView>(R.id.textRodar)

        textResultado.text = valor.toString()
    }
}
