package com.jorfald.kristianiacalculator.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jorfald.kristianiacalculator.R
import kotlinx.android.synthetic.main.main_fragment.view.*
import kotlin.concurrent.fixedRateTimer

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private lateinit var resultTextView: TextView
    private lateinit var clearButton: TextView
    private lateinit var divideButton: TextView
    private lateinit var timesButton: TextView
    private lateinit var minusButton: TextView
    private lateinit var plusButton: TextView
    private lateinit var nineButton: TextView
    private lateinit var eightButton: TextView
    private lateinit var sevenButton: TextView
    private lateinit var sixButton: TextView
    private lateinit var fiveButton: TextView
    private lateinit var fourButton: TextView
    private lateinit var threeButton: TextView
    private lateinit var twoButton: TextView
    private lateinit var oneButton: TextView
    private lateinit var zeroButton: TextView
    private lateinit var decimalButton: TextView
    private lateinit var equalsButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)

        resultTextView = view.result

        clearButton = view.clear
        divideButton = view.divide
        timesButton = view.times
        minusButton = view.minus
        plusButton = view.plus

        nineButton = view.nine
        eightButton = view.eight
        sevenButton = view.seven
        sixButton = view.six
        fiveButton = view.five
        fourButton = view.four
        threeButton = view.three
        twoButton = view.two
        oneButton = view.one
        zeroButton = view.zero

        decimalButton = view.decimal
        equalsButton = view.equals

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindButtons()
    }

    private fun bindButtons() {
        clearButton.setOnClickListener {
            writeText(viewModel.clearValues())
        }

        divideButton.setOnClickListener {
            writeText(viewModel.typeExpression("/"))
        }

        timesButton.setOnClickListener {
            writeText(viewModel.typeExpression("*"))
        }

        minusButton.setOnClickListener {
            writeText(viewModel.typeExpression("-"))
        }

        plusButton.setOnClickListener {
            writeText(viewModel.typeExpression("+"))
        }

        nineButton.setOnClickListener {
            writeText(viewModel.typeNumber(9))
        }

        eightButton.setOnClickListener {
            writeText(viewModel.typeNumber(8))
        }

        sevenButton.setOnClickListener {
            writeText(viewModel.typeNumber(7))
        }

        sixButton.setOnClickListener {
            writeText(viewModel.typeNumber(6))
        }

        fiveButton.setOnClickListener {
            writeText(viewModel.typeNumber(5))
        }

        fourButton.setOnClickListener {
            writeText(viewModel.typeNumber(4))
        }

        threeButton.setOnClickListener {
            writeText(viewModel.typeNumber(3))
        }

        twoButton.setOnClickListener {
            writeText(viewModel.typeNumber(2))
        }

        oneButton.setOnClickListener {
            writeText(viewModel.typeNumber(1))
        }

        zeroButton.setOnClickListener {
            writeText(viewModel.typeNumber(0))
        }

        decimalButton.setOnClickListener {
            writeText(viewModel.typeDecimal())
        }

        equalsButton.setOnClickListener {
            writeText(viewModel.calculate())
        }
    }

    private fun writeText(text: String) {
        if (text.isNotEmpty()) {
            resultTextView.text = text
        }
    }
}