package com.example.calculator


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
// use kotlinx...syntethic...main.* import to get widget references from activity_main.xml

private const val TAG = "mainActivity"
private const val STATE_PENDING_OPERATION = "Pending Operation"
private const val STATE_OPERAND1 = "Operand1"
private const val STATE_OPERAND1_STORED = "Operand1 Stored"



class MainActivity : AppCompatActivity() {
    // variables to hold operands and type of calculations
    private var operand1: Double? = null
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = View.OnClickListener { v ->
            val button = v as Button
            newNumber.append(button.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val opButton = (v as Button).text.toString()
            try {
                val value = newNumber.text.toString().toDouble()
                performOperation(value, opButton)

            } catch (e: NumberFormatException) {
                newNumber.setText("")
            }
            pendingOperation = opButton
            operation.text = pendingOperation
        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

//        // my solution
//        buttonNeg.setOnClickListener(View.OnClickListener { v ->
//            try {
//                var value = newNumber.text.toString().toDouble()
//                value *= -1
//                newNumber.setText(value.toString())
//            } catch (e: NumberFormatException) {
//                if (newNumber.text.toString() == "-") {
//                    newNumber.setText("")
//                } else {
//                    newNumber.setText("-")
//                }
//            }
//        })

        // Tim's solution
        buttonNeg.setOnClickListener {
            val value = newNumber.text.toString()
            if (value.isEmpty()) {
                newNumber.setText("-")
            } else {
                try {
                    var doubleValue = value.toDouble()
                    doubleValue *= -1
                    newNumber.setText(doubleValue.toString())
                } catch (e: java.lang.NumberFormatException) {
                    newNumber.setText("")
                }
            }
        }

        buttonClear.setOnClickListener{
            result.setText("")
            newNumber.setText("")
            operation.text = ""
        }


    }

    private fun performOperation(value: Double, operation: String) {
        if (operand1 == null) {
            operand1 = value
        } else {
            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) {
                "=" -> operand1 = value
                "+" -> operand1 = operand1!! + value
                "-" -> operand1 = operand1!! - value
                "*" -> operand1 = operand1!! * value
                "/" -> operand1 = if (value == 0.0) {
                                    Double.NaN
                                } else {
                                    operand1!! / value
                                }
            }
            result.setText(operand1.toString())
            newNumber.setText("")
        }
    }


    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        operand1 = if (savedInstanceState.getBoolean(STATE_OPERAND1_STORED, false)) {
                        savedInstanceState.getDouble(STATE_OPERAND1)
                } else {
                        null
                }
        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION)!!
        operation.text = pendingOperation

    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        if (operand1 != null) {
            outState.putDouble(STATE_OPERAND1, operand1!!)
            outState.putBoolean(STATE_OPERAND1_STORED, true)
        }
        outState.putString(STATE_PENDING_OPERATION, pendingOperation)
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }
}












































