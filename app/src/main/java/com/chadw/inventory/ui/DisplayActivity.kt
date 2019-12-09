package com.chadw.inventory.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.chadw.inventory.R
import com.chadw.inventory.model.Item
import com.pawegio.kandroid.textWatcher
import kotlinx.android.synthetic.main.activity_display.*
import org.w3c.dom.Text

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)


        purchPriceField.setOnFocusChangeListener { v, hasFocus -> updateFieldString(v as EditText);updateTotalCost();updateNetProfit()}
        matPriceField.setOnFocusChangeListener { v, hasFocus -> updateFieldString(v as EditText);updateTotalCost();updateNetProfit() }
        laborChargeField.setOnFocusChangeListener { v, hasFocus -> updateFieldString(v as EditText);updateTotalCost();updateNetProfit() }
        askingPriceField.setOnFocusChangeListener { v, hasFocus -> updateFieldString(v as EditText);updateTotalCost();updateNetProfit() }


    }

    fun updateNetProfit() {
        var totalPrice = 0.0
        var askingPrice = 0.0

        val totalPriceString = totalPriceField.text.toString()
        if (totalPriceString.isNotEmpty()) {
            totalPrice = totalPriceString.substringAfter("$").toDouble()
        }

        val askingPriceString = askingPriceField.text.toString()
        if (askingPriceString.isNotEmpty()) {
            askingPrice = askingPriceString.substringAfter("$").toDouble()
        }
        val profit = askingPrice - totalPrice
        if (profit < 0) {
            netProfitField.setTextColor(Color.parseColor("#ff0000"))
        } else {
            netProfitField.setTextColor(Color.parseColor("#000000"))
        }
        val profitString = "$%.2f".format(profit)
        netProfitField.setText(profitString)
    }

    private fun updateTotalCost() {
        var purchPrice = 0.0
        var matPrice = 0.0
        var laborPrice = 0.0

        val purchPriceString = purchPriceField.text.toString()
        if (!purchPriceString.isEmpty()) {
            purchPrice = purchPriceString.substringAfter("$").toDouble()
        }

        val matPriceString = matPriceField.text.toString()
        if (!matPriceString.isEmpty()) {
            matPrice = matPriceString.substringAfter("$").toDouble()
        }

        val laborPriceString = laborChargeField.text.toString()
        if (!laborPriceString.isEmpty()) {
            laborPrice = laborPriceString.substringAfter("$").toDouble()
        }

        val totalCost = purchPrice + matPrice + laborPrice
        val totalCostString = "$%.2f".format(totalCost)
        totalPriceField.setText(totalCostString)


    }

    private fun updateFieldString(e: EditText) {
        val string = e.text.toString()
        if (string.isEmpty()) {
            return
        }
        if (string.contains("$")) {
            return
        }
        val amount = string.substringAfter("$").toDouble()
        e.setText("$%.2f".format(amount))
    }
}
