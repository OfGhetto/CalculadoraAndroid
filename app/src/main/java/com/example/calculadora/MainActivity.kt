package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var resultado: Double = 1.0
    private var operacion: Int = 0
    private var num1Double: Double = 0.0
    private var num2Double: Double = 0.0
    private var size: Int = 0
    private var i: Int = 0
    private var num2String: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        salida.text = "0"
        operacion = SIN

        uno.setOnClickListener { presionado("1") }
        dos.setOnClickListener { presionado("2") }
        tres.setOnClickListener { presionado("3") }
        cuatro.setOnClickListener { presionado("4") }
        cinco.setOnClickListener { presionado("5") }
        seis.setOnClickListener { presionado("6") }
        siete.setOnClickListener { presionado("7") }
        ocho.setOnClickListener { presionado("8") }
        nueve.setOnClickListener { presionado("9") }
        cero.setOnClickListener { presionado("0") }

        borrar.setOnClickListener { clearAll() }
        borrarUltimo.setOnClickListener { clearLast() }

        suma.setOnClickListener { operacion(SUMA) }
        resta.setOnClickListener { operacion(RESTA) }
        mutiplicacion.setOnClickListener { operacion(MULTI) }
        division.setOnClickListener { operacion(DIVI) }
        //punto.setOnClickListener { }
        igual.setOnClickListener { igual() }
    }

    fun presionado(numero: String) {
        if (salida.text.equals("0") || salida.text.equals(null) || salida.text.equals(".")) {
            salida.text = "$numero"
        } else {
            salida.text = "${salida.text}$numero"

        }
    }

    fun igual() {
        val char = salida.text.toString().toCharArray()
        i = size
        while (i < char.size) {
            num2String = "${num2String}${char.get(i)}"
            i++
        }
        num2 = num2String.toString().toDouble()
        /*if (num1 == 27092005 || num2 == 27092005){
            salida.text = "JULY CHIKITA JOTA"*/


        //}else {
        /*if (num1 == 11102005 || num2 == 11102005){
            salida.text = "JUANPEDRO FUNAO"
            return
        }*/
        resultado = when (operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTI -> num1 * num2
            DIVI -> if (num2 == 0.0) {
                salida.text = "No se puede dividir por 0"
                return
            } else {
                num1 / num2
            }
            else -> 0.0
        }
        if (resultado == 21133994.0) {
            salida.text = "Te espero en mi casa bb <3"
            return
        }
        if (num1 == 4071997.0 || num2 == 4071997.0) {
            salida.text = "Chupalo JEJE"
            return
        }
        /*if(resultado == 14064012){
            salida.text = "CaCaS Y Casarla IS REAL"
            return
        }*/
        salida.text = if ("$resultado".endsWith(".0")) {
            "$resultado".replace(".0", "")
        } else {
            "%.2f".format(resultado)
        }
        clearOnlyVar()


        //}
    }

    fun operacion(operacion: Int) {
        this.operacion = operacion
        if (resultado != 0.0) {
            num1 = resultado
            when (operacion) {
                SUMA -> {
                    salida.text = "${salida.text}+"
                }

                RESTA -> {
                    salida.text = "${salida.text}-"

                }

                MULTI -> {
                    salida.text = "${salida.text}*"

                }
                DIVI -> {
                    salida.text = "${salida.text}/"

                }
                else -> return
            }
            size = salida.text.toString().toCharArray().size
        } else {
            num1 = salida.text.toString().toDouble()
            when (operacion) {
                SUMA -> {
                    salida.text = "${salida.text}+"
                }

                RESTA -> {
                    salida.text = "${salida.text}-"

                }

                MULTI -> {
                    salida.text = "${salida.text}*"

                }
                DIVI -> {
                    salida.text = "${salida.text}/"

                }
                else -> return
            }
            size = salida.text.toString().toCharArray().size
        }
    }


    fun clearAll() {
        salida.text = "0"
        num1 = 0.0
        num2 = 0.0
        num1Double = 0.0
        num2Double = 0.0
        size = 0
        num2String = ""
        i = 0
        resultado = 0.0
    }

    fun clearOnlyVar() {
        num1 = 0.0
        num2 = 0.0
        num1Double = 0.0
        num2Double = 0.0
        size = 0
        num2String = ""
        i = 0
    }

    fun clearLast() {
        salida.text = "0"
        if (num1 != 0.0 || num1Double != 0.0) {
            num2 = 0.0
            num2Double = 0.0
            num2String = ""
            i = 0
            size = 0
        } else {
            num1 = 0.0
            num1Double = 0.0
            num2String = ""
            i = 0
            size = 0
        }
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTI = 3
        const val DIVI = 4
        const val PUNTO = 5
        const val SIN = 0

    }
}