package com.jorfald.kristianiacalculator.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var expression: String = ""

    fun calculate(): String {
        if (firstNumber.endsWith('.')) {
            firstNumber = firstNumber.substring(0, firstNumber.length - 2)
        }

        if (secondNumber.endsWith('.')) {
            secondNumber = secondNumber.substring(0, secondNumber.length - 2)
        }

        return when (expression) {
            "+" -> plus()
            "-" -> minus()
            "/" -> divide()
            "*" -> times()
            else -> getError("Wrong expression")
        }
    }

    fun plus(): String {
        return try {
            (firstNumber.toDouble() + secondNumber.toDouble()).toString()
        } catch (e: Exception) {
            getError("Could not add")
        }
    }

    fun minus(): String {
        return try {
            (firstNumber.toDouble() - secondNumber.toDouble()).toString()
        } catch (e: Exception) {
            getError(e.localizedMessage)
        }
    }

    fun divide(): String {
        return try {
            (firstNumber.toDouble() / secondNumber.toDouble()).toString()
        } catch (e: Exception) {
            getError(e.localizedMessage)
        }
    }

    fun times(): String {
        return try {
            (firstNumber.toDouble() * secondNumber.toDouble()).toString()
        } catch (e: Exception) {
            getError(e.localizedMessage)
        }
    }

    fun getError(errorText: String?): String {
        return "Error! - $errorText"
    }

    fun clearValues(): String {
        firstNumber = ""
        secondNumber = ""
        expression = ""

        return "0"
    }

    fun typeExpression(expressionToWrite: String): String {
        return if (isValidExpression(expressionToWrite)) {
            if (firstNumber.isNotEmpty()) {
                expression = expressionToWrite
                return expression
            } else {
                ""
            }
        } else {
            getError("Invalid expression")
        }
    }

    private fun isValidExpression(expressionToCheck: String): Boolean {
        return when (expressionToCheck) {
            "+",
            "-",
            "/",
            "*" -> true
            else -> false
        }
    }

    fun typeNumber(numberToWrite: Int): String {
        return if (numberToWrite in 0..9) {
            if (expression.isEmpty()) {
                firstNumber += numberToWrite
                firstNumber
            } else {
                secondNumber += numberToWrite
                secondNumber
            }
        } else {
            getError("Invalid number")
        }
    }

    fun typeDecimal(): String {
        return if (expression.isEmpty()) {
            if (firstNumber.contains('.')) {
                ""
            } else {
                if (firstNumber.isNotEmpty()) {
                    firstNumber += "."
                    firstNumber
                } else {
                    ""
                }
            }
        } else {
            if (secondNumber.contains('.')) {
                ""
            } else {
                if (firstNumber.isNotEmpty()) {
                    secondNumber += "."
                    secondNumber
                } else {
                    ""
                }
            }
        }
    }
}