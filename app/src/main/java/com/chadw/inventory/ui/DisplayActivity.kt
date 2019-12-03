package com.chadw.inventory.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chadw.inventory.R
import com.chadw.inventory.model.Item
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

    }
    fun updateNetProfit(){
       var profit: Double? = null
        profit = askingPriceField.text.toString().toDouble() - totalPriceField.text.toString().toDouble()
        val profitString :String = "$" + profit.toString()
        netProfitField.setText(profitString)
    }
    fun updateTotalCost(){
        var totalCost: Double? = null
        totalCost = purchPriceField.text.toString().toDouble() + matPriceField.text.toString().toDouble() + laborChargeField.text.toString().toDouble()
        val totalCostString = "$" + totalCost.toString()
        totalPriceField.setText(totalCostString)
    }
}
