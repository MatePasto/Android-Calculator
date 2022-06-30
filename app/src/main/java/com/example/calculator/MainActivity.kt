package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operationToDo: String = "0"
    var btnInsert: String = ""
    var value1: Double = 0.0
    var value2: Double = 0.0
    var valueOverrite: Int = 1
    var resultValue: Double = 0.0
    val sumOperator: MathOperators = Sum()
    val subtractOperator: MathOperators = Subtract()
    val multiplyOperator: MathOperators = Multiply()
    val divisionOperator: MathOperators = Division()

// ------------------------------------------------------------------------------------------------
// Layout import
// ------------------------------------------------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// ------------------------------------------------------------------------------------------------
// Main execution code
// ------------------------------------------------------------------------------------------------

        fun btnPressed(value: String) { btnInsert += value }

        fun cleanDisplay() {
            tv_value_display.text = "0"
            tv_operator_display.text = ""
        }

        fun reset() {
            operationToDo = "0"
            btnInsert = ""
            value1 = 0.0
            value2 = 0.0
            valueOverrite = 1
        }

        fun numberBtn(btn: Button) {
            if (tv_value_display.text == "0" || tv_value_display.text == resultValue.toString()) {
                tv_value_display.text = "0"
                resultValue = 0.0
                btnPressed(btn.hint.toString())
                tv_value_display.text = btn.hint.toString()
            } else {
                btnPressed(btn.hint.toString())
                tv_value_display.text =
                    tv_value_display.text.toString() + btn.hint.toString()
            }
        }

        fun operatorBtn(btn: Button) {
            cleanDisplay()
            value1 = btnInsert.toDouble()
            btnInsert = ""
            tv_operator_display.text = btn.hint
            operationToDo = btn.hint.toString()
        }

        fun opertation(value1: Double, value2: Double): Double {
            if (operationToDo == "+")
            { return sumOperator.doOperation(value1, value2)}
            else if (operationToDo == "-")
            { return subtractOperator.doOperation(value1, value2)}
            else if (operationToDo == "*")
            { return multiplyOperator.doOperation(value1, value2)}
            else if (operationToDo == "/")
            { return divisionOperator.doOperation(value1, value2)}
            return 0.0
        }

        fun equalBtnPressed(btn: Button) {
            value2 = btnInsert.toDouble()
            resultValue = opertation(value1, value2)
            btnInsert = ""
            btnPressed(btn.hint.toString())
            tv_operator_display.text = ""
            tv_value_display.text = resultValue.toString()
            reset()
        }

// ------------------------------------------------------------------------------------------------
// OnClickListener for each button
// ------------------------------------------------------------------------------------------------

        btn_0.setOnClickListener { numberBtn(btn_0) }
        btn_1.setOnClickListener { numberBtn(btn_1) }
        btn_2.setOnClickListener { numberBtn(btn_2) }
        btn_3.setOnClickListener { numberBtn(btn_3) }
        btn_4.setOnClickListener { numberBtn(btn_4) }
        btn_5.setOnClickListener { numberBtn(btn_5) }
        btn_6.setOnClickListener { numberBtn(btn_6) }
        btn_7.setOnClickListener { numberBtn(btn_7) }
        btn_8.setOnClickListener { numberBtn(btn_8) }
        btn_9.setOnClickListener { numberBtn(btn_9) }
        equal_btn.setOnClickListener { equalBtnPressed(equal_btn) }
        sum_btn.setOnClickListener { operatorBtn(sum_btn) }
        subtract_btn.setOnClickListener { operatorBtn(subtract_btn) }
        multiply_btn.setOnClickListener { operatorBtn(multiply_btn) }
        division_btn.setOnClickListener { operatorBtn(division_btn) }
        ac_btn.setOnClickListener { cleanDisplay() }
    }
}
