package com.example.calculadora
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

class Calculadora {
    private val pattern = "([()])|(\\d+(\\.\\d+)?)|([+*×÷/-])"
    private var op:String = ""

    fun getResultado(op:String):Double{
        this.op = op
        val tokens = parseTokens(op)
        return 0.0
    }

    fun parseTokens(op : String): List<String>{
        val pattern = Pattern.compile(pattern)
        val matcher= pattern.matcher(op)
        val tokens = ArrayList<String>()
        while (matcher.find()){
            tokens.add(matcher.group())
        }
        return tokens
    }


}