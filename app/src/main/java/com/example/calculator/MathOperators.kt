package com.example.calculator

interface MathOperators {
    fun doOperation(value1: Int, value2: Int): Int
}

class Sum(): MathOperators {
    override fun doOperation(value1: Int, value2: Int) = value1 + value2
}

class Subtract(): MathOperators {
    override fun doOperation(value1: Int, value2: Int) = value1 - value2
}

class Multiply(): MathOperators {
    override fun doOperation(value1: Int, value2: Int) = value1 * value2
}

class Division(): MathOperators {
    override fun doOperation(value1: Int, value2: Int) = value1 / value2
}
