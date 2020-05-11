package edu.student.finalappsimplecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtNum1 = findViewById<EditText>(R.id.txtNum1)
        var txtNum2 = findViewById<EditText>(R.id.txtNum2)
        var btnAdd = findViewById<Button>(R.id.btnAdd)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        var btnSubtract = findViewById<Button>(R.id.btnSubtract)
        var btnMultiply = findViewById<Button>(R.id.btnMultiply)
        var btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener{
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            val showAdd: Int = Addition(n1, n2)
            txtResult.text = "The sum is ${showAdd}"
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }

        btnSubtract.setOnClickListener{
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            val showSub: Int = Subtraction(n1, n2)
            txtResult.text = "The subtraction is ${showSub}"
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }

        btnMultiply.setOnClickListener{
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            val showMult: Int = Multiply(n1, n2)
            txtResult.text = "The multiplication is ${showMult}"
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }

        btnDivide.setOnClickListener{
            val n1: Int = txtNum1.text.toString().toInt()
            val n2: Int = txtNum2.text.toString().toInt()
            val showDivide: Int = Divide(n1, n2)
            txtResult.text = "The division is ${showDivide}"
            txtNum1.setText("")
            txtNum2.setText("")
            txtNum1.requestFocus()
            hideKeyboard()
        }

        findViewById<View>(android.R.id.content).setOnTouchListener {_, event ->
            hideKeyboard()
            false
        }
    }

    fun Addition(a: Int, b:Int): Int {
        return a + b
    }

    fun Subtraction(a: Int, b:Int): Int {
        return a - b
    }

    fun Multiply(a: Int, b:Int): Int {
        return a * b
    }

    fun Divide(a: Int, b:Int): Int {
        return a/b
    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {

        }
    }
}
