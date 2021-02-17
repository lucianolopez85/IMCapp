package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calcular = bt_calcular

        calcular.setOnClickListener{
            var pesoVazio = edit_peso.text.toString()
            var alturaVazio = edit_altura.text.toString()

            if(pesoVazio.isEmpty()){
                result.setText("Informe o seu Peso")
            }else if(alturaVazio.isEmpty()){
                result.setText("Informe a sua Altura")
            }else{
                CalculeIMC()
            }
        }

        img_delete.setOnTouchListener{v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                edit_peso.setText("")
                edit_altura.setText("")
                result.setText("")
            }
        false }
    }

    private fun CalculeIMC(){
        var peso = Integer.parseInt(edit_peso.text.toString())
        var altura = java.lang.Float.parseFloat(edit_altura.text.toString())
        var resultado = result
        val imc = peso / (altura * altura)

        val result = when{

            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade (Grau 1)"
            imc <= 39.9 -> "Obesidade (Grau 2)"
            else -> "Obesidade Mórbida (Grau 3)"
        }
        resultado.text = "IMC:" + " " + imc.toString() + "\n" + result
    }
}
