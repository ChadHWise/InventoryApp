package com.chadw.inventory.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.EditorInfo.*
import android.widget.EditText
import com.chadw.inventory.R
import com.chadw.inventory.model.Item
import com.pawegio.kandroid.textWatcher
import kotlinx.android.synthetic.main.activity_display.*
import org.w3c.dom.Text

class DisplayActivity : AppCompatActivity() {

    var tWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            updateTotalCost()
            updateNetProfit()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        purchPriceField.addTextChangedListener(this.tWatcher)
        matPriceField.addTextChangedListener(this.tWatcher)
        laborChargeField.addTextChangedListener(this.tWatcher)
        askingPriceField.addTextChangedListener(this.tWatcher)


        purchPriceField.setOnFocusChangeListener { v, hasFocus -> updatePriceFieldString(v as EditText) }
        matPriceField.setOnFocusChangeListener { v, hasFocus -> updatePriceFieldString(v as EditText) }
        laborChargeField.setOnFocusChangeListener { v, hasFocus -> updatePriceFieldString(v as EditText) }
        askingPriceField.setOnFocusChangeListener { v, hasFocus -> updatePriceFieldString(v as EditText) }
        heightField.setOnFocusChangeListener { v, hasFocus -> updateSizeFieldString(v as EditText) }
        widthField.setOnFocusChangeListener { v, hasFocus -> updateSizeFieldString(v as EditText) }
        lengthField.setOnFocusChangeListener { v, hasFocus -> updateSizeFieldString(v as EditText) }


    }

    fun updateNetProfit() {
        var totalPrice = 0.0
        var askingPrice = 0.0

        val totalPriceString = totalPriceField.text.toString()
        if (totalPriceString.isNotEmpty()) {
            totalPrice = totalPriceString.substringAfter("$").toDouble()
        }

        var askingPriceString = askingPriceField.text.toString()
        if (askingPriceString.isNotEmpty()) {
            if (askingPriceString.contains("$") && askingPriceString.length == 1) {
                askingPriceString = "$0.00"
            }
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

        var purchPriceString = purchPriceField.text.toString()
        if (purchPriceString.isNotEmpty()) {
            if (purchPriceString.contains("$") && purchPriceString.length == 1) {
                purchPriceString = "$0.00"
            }
            purchPrice = purchPriceString.substringAfter("$").toDouble()

        }

        var matPriceString = matPriceField.text.toString()
        if (matPriceString.isNotEmpty()) {
            if (matPriceString.contains("$") && matPriceString.length == 1) {
                matPriceString = "$0.00"
            }
            matPrice = matPriceString.substringAfter("$").toDouble()
        }


        var laborPriceString = laborChargeField.text.toString()
        if (laborPriceString.isNotEmpty()) {
            if (laborPriceString.contains("$") && laborPriceString.length == 1) {
                laborPriceString = "$0.00"
            }
            laborPrice = laborPriceString.substringAfter("$").toDouble()

        }

        val totalCost = purchPrice + matPrice + laborPrice
        val totalCostString = "$%.2f".format(totalCost)
        totalPriceField.setText(totalCostString)


    }

    private fun updatePriceFieldString(e: EditText) {
        var string = e.text.toString()
        if (string.isEmpty()) {
            return
        }
        if (string.contains("$")) {
            if (string.length == 1) {
                e.setText("")
                return
            } else {
                return
            }
        }
        val amount = string.substringAfter("$").toDouble()
        e.setText("$%.2f".format(amount))
    }

    private fun updateSizeFieldString(e: EditText) {
        var string = e.text.toString()
        if (string.isEmpty()) {
            return
        }
        if (string.contains(' ')) string = string.substringBefore(" ")
        e.setText("%s in".format(string))
    }
}
