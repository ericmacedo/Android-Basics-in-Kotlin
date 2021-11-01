package com.example.tiptime

import android.content.Context
import kotlin.math.ceil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ binding.tipResult.text = calculateTip() }
        
        binding.costOfServiceEditText.setOnKeyListener { v, key, _ -> handleKeyEvent(v, key) }
    }

    private fun calculateTip(): String {
        val cost: Double? = this.binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        val percentage: Double = when(binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> .2
            R.id.option_eighteen_percent -> .18
            else -> .15
        }

        if(cost == null) {
            return ""
        }
        val tip: Double = cost * percentage
        return getString(R.string.tip_amount, NumberFormat.getCurrencyInstance().format(
            if(binding.roundUpSwitch.isChecked) ceil(tip) else tip
        ))
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}