package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operationToDo: String = "0"
    var btnInsert: String = ""
    var value1: Int = 0
    var value2: Int = 0
    var resultValue: Float = 0F
    val sumOperators: MathOperators = Sum()
    val subtractOperators: MathOperators = Subtract()
    val multiplyOperators: MathOperators = Multiply()
    val divisionOperators: MathOperators = Division()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun opertation(value1: Int, value2: Int): Int {
            if (operationToDo == "+")
            { return sumOperators.doOperation(value1, value2)}
            else if (operationToDo == "-")
            { return subtractOperators.doOperation(value1, value2)}
            else if (operationToDo == "*")
            { return multiplyOperators.doOperation(value1, value2)}
            else if (operationToDo == "/")
            { return divisionOperators.doOperation(value1, value2)}
            return 0
        }

        fun btnPressed(value: String) { btnInsert += value }

        fun reset() {
            operationToDo = "0"
            btnInsert = ""
            value1 = 0
            value2 = 0
            resultValue = 0F
            tv_value1_display.text = "0"
            tv_operator_display.text = ""
        }

        fun pressinBtn(btn: Button) {
            if (value1 == 0) {
                if (btn == sum_btn || btn == subtract_btn || btn == multiply_btn || btn == division_btn) {
                    this.value1 = btnInsert.toInt()
                    operationToDo = btn.hint.toString()
                    btnPressed(btn.hint.toString())
                    tv_operator_display.text = btn.hint.toString()
                    btnInsert = ""
                } else if (btn == ac_btn || tv_value1_display.text == "0") {
                    btnPressed(btn.hint.toString())
                    tv_value1_display.text = btn.hint.toString()
                } else {
                    tv_value2_display.text = "0"
                    btnPressed(btn.hint.toString())
                    tv_value1_display.text =
                        tv_value1_display.text.toString() + btn.hint.toString()
                }
            } else {
                if (btn == ac_btn || tv_value2_display.text == "0") {
                    btnPressed(btn.hint.toString())
                    tv_value2_display.text = btn.hint.toString()
                } else if (btn == equal_btn) {
                    this.value2 = btnInsert.toInt()
                    resultValue = opertation(value1, value2).toFloat()
                    btnInsert = ""
                    btnPressed(btn.hint.toString())
                    tv_value2_display.text =btn.hint.toString()
                    tv_value2_display.text = resultValue.toString()
                    reset()
                } else {
                    btnPressed(btn.hint.toString())
                    tv_value2_display.text =
                        tv_value2_display.text.toString() + btn.hint.toString()
                }
            }
        }

// On Click Listener for each button

        btn_0.setOnClickListener { pressinBtn(btn_0) }
        btn_1.setOnClickListener { pressinBtn(btn_1) }
        btn_2.setOnClickListener { pressinBtn(btn_2) }
        btn_3.setOnClickListener { pressinBtn(btn_3) }
        btn_4.setOnClickListener { pressinBtn(btn_4) }
        btn_5.setOnClickListener { pressinBtn(btn_5) }
        btn_6.setOnClickListener { pressinBtn(btn_6) }
        btn_7.setOnClickListener { pressinBtn(btn_7) }
        btn_8.setOnClickListener { pressinBtn(btn_8) }
        btn_9.setOnClickListener { pressinBtn(btn_9) }
        equal_btn.setOnClickListener { pressinBtn(equal_btn) }
        sum_btn.setOnClickListener { pressinBtn(sum_btn) }
        subtract_btn.setOnClickListener { pressinBtn(subtract_btn) }
        multiply_btn.setOnClickListener { pressinBtn(multiply_btn) }
        division_btn.setOnClickListener { pressinBtn(division_btn) }
        ac_btn.setOnClickListener { pressinBtn(ac_btn) }
    }
}
