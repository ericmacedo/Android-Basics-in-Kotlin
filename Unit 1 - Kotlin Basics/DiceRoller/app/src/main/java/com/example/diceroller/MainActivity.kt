package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Dice(private val sides: Int = 6) {
    fun roll(): Int {
        return (1..this.sides).random()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { this.rollDice() }

        this.rollDice()
    }

    private fun rollDice () {
        val rolled: Int = Dice().roll()
        val diceSide: ImageView = findViewById(R.id.dice_image)

        diceSide.setImageResource(when (rolled) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
        diceSide.contentDescription = "A dice with the side $rolled up"
    }
}