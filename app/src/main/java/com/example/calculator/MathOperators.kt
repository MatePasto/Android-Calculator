package com.example.calculator

interface MathOperators {
    fun doOperation(value1: Double, value2: Double): Double
}

class Sum(): MathOperators {
    override fun doOperation(value1: Double, value2: Double) = value1 + value2
}

class Subtract(): MathOperators {
    override fun doOperation(value1: Double, value2: Double) = value1 - value2
}

class Multiply(): MathOperators {
    override fun doOperation(value1: Double, value2: Double) = value1 * value2
}

class Division(): MathOperators {
    override fun doOperation(value1: Double, value2: Double) = value1 / value2
}
