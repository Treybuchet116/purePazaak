package com.treybuchet.purepazaak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.treybuchet.purepazaak.databinding.ActivitySideDeck2Binding
import com.treybuchet.purepazaak.util.PrefUtil

class SideDeckActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySideDeck2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySideDeck2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var num_side_deck = PrefUtil.getNumSideDeck(this)
        var player_side_deck_array = PrefUtil.getPlayerSideDeck(this)
        var player_side_deck = player_side_deck_array.toMutableList()
        var textViews = listOf(binding.tv1Blue, binding.tv2Blue, binding.tv3Blue, binding.tv4Blue,
            binding.tv5Blue, binding.tv6Blue, binding.tv1Blue, binding.tv2Blue, binding.tv3Blue,
            binding.tv4Blue, binding.tv5Blue, binding.tv6Blue, binding.tv1BlueFlip, binding.tv2BlueFlip,
            binding.tv3BlueFlip, binding.tv4BlueFlip, binding.tv5BlueFlip, binding.tv6BlueFlip)
        var blue_1_number = PrefUtil.getBlue1(this)
        var blue_2_number = PrefUtil.getBlue2(this)
        var blue_3_number = PrefUtil.getBlue3(this)
        var blue_4_number = PrefUtil.getBlue4(this)
        var blue_5_number = PrefUtil.getBlue5(this)
        var blue_6_number = PrefUtil.getBlue6(this)

        var red_1_number = PrefUtil.getRed1(this)
        var red_2_number = PrefUtil.getRed2(this)
        var red_3_number = PrefUtil.getRed3(this)
        var red_4_number = PrefUtil.getRed4(this)
        var red_5_number = PrefUtil.getRed5(this)
        var red_6_number = PrefUtil.getRed6(this)

        var blue_flip_1_number = PrefUtil.getBlueFlip1(this)
        var blue_flip_2_number = PrefUtil.getBlueFlip2(this)
        var blue_flip_3_number = PrefUtil.getBlueFlip3(this)
        var blue_flip_4_number = PrefUtil.getBlueFlip4(this)
        var blue_flip_5_number = PrefUtil.getBlueFlip5(this)
        var blue_flip_6_number = PrefUtil.getBlueFlip6(this)

        binding.tv1Blue?.text = blue_1_number.toString()
        binding.tv2Blue?.text = blue_2_number.toString()
        binding.tv3Blue?.text = blue_3_number.toString()
        binding.tv4Blue?.text = blue_4_number.toString()
        binding.tv5Blue?.text = blue_5_number.toString()
        binding.tv6Blue?.text = blue_6_number.toString()

        binding.tv1Red?.text = red_1_number.toString()
        binding.tv2Red?.text = red_2_number.toString()
        binding.tv3Red?.text = red_3_number.toString()
        binding.tv4Red?.text = red_4_number.toString()
        binding.tv5Red?.text = red_5_number.toString()
        binding.tv6Red?.text = red_6_number.toString()

        binding.tv1BlueFlip?.text = blue_flip_1_number.toString()
        binding.tv2BlueFlip?.text = blue_flip_2_number.toString()
        binding.tv3BlueFlip?.text = blue_flip_3_number.toString()
        binding.tv4BlueFlip?.text = blue_flip_4_number.toString()
        binding.tv5BlueFlip?.text = blue_flip_5_number.toString()
        binding.tv6BlueFlip?.text = blue_flip_6_number.toString()



        binding.btn1BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_1_number++
                num_side_deck++
                binding.tv1Blue?.text = blue_1_number.toString()
                PrefUtil.setBlue1(blue_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_1"
            }
        }
        binding.btn1BlueDown?.setOnClickListener {
            if (blue_1_number > 0) {
                blue_1_number--
                num_side_deck--
                binding.tv1Blue?.text = blue_1_number.toString()
                PrefUtil.setBlue1(blue_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_1")
            }
        }
        binding.btn2BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_2_number++
                num_side_deck++
                binding.tv2Blue?.text = blue_2_number.toString()
                PrefUtil.setBlue2(blue_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_2"

            }
        }
        binding.btn2BlueDown?.setOnClickListener {
            if (blue_2_number > 0) {
                blue_2_number--
                num_side_deck--
                binding.tv2Blue?.text = blue_2_number.toString()
                PrefUtil.setBlue2(blue_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_2")
            }
        }
        binding.btn3BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_3_number++
                num_side_deck++
                binding.tv3Blue?.text = blue_3_number.toString()
                PrefUtil.setBlue3(blue_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_3"
            }
        }
        binding.btn3BlueDown?.setOnClickListener {
            if (blue_3_number > 0) {
                blue_3_number--
                num_side_deck--
                binding.tv3Blue?.text = blue_3_number.toString()
                PrefUtil.setBlue3(blue_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_3")
            }
        }
        binding.btn4BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_4_number++
                num_side_deck++
                binding.tv4Blue?.text = blue_4_number.toString()
                PrefUtil.setBlue4(blue_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_4"
            }
        }
        binding.btn4BlueDown?.setOnClickListener {
            if (blue_4_number > 0) {
                blue_4_number--
                num_side_deck--
                binding.tv4Blue?.text = blue_4_number.toString()
                PrefUtil.setBlue4(blue_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_4")
            }
        }
        binding.btn5BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_5_number++
                num_side_deck++
                binding.tv5Blue?.text = blue_5_number.toString()
                PrefUtil.setBlue5(blue_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_5"
            }
        }
        binding.btn5BlueDown?.setOnClickListener {
            if (blue_5_number > 0) {
                blue_5_number--
                num_side_deck--
                binding.tv5Blue?.text = blue_5_number.toString()
                PrefUtil.setBlue5(blue_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_5")
            }
        }
        binding.btn6BlueUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_6_number++
                num_side_deck++
                binding.tv6Blue?.text = blue_6_number.toString()
                PrefUtil.setBlue6(blue_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_6"
            }
        }
        binding.btn6BlueDown?.setOnClickListener {
            if (blue_6_number > 0) {
                blue_6_number--
                num_side_deck--
                binding.tv6Blue?.text = blue_6_number.toString()
                PrefUtil.setBlue6(blue_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_6")
            }
        }

        binding.btn1RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_1_number++
                num_side_deck++
                binding.tv1Red?.text = red_1_number.toString()
                PrefUtil.setRed1(red_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_1"
            }
        }
        binding.btn1RedDown?.setOnClickListener {
            if (red_1_number > 0) {
                red_1_number--
                num_side_deck--
                binding.tv1Red?.text = red_1_number.toString()
                PrefUtil.setRed1(red_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_1")
            }
        }
        binding.btn2RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_2_number++
                num_side_deck++
                binding.tv2Red?.text = red_2_number.toString()
                PrefUtil.setRed2(red_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_2"
            }
        }
        binding.btn2RedDown?.setOnClickListener {
            if (red_2_number > 0) {
                red_2_number--
                num_side_deck--
                binding.tv2Red?.text = red_2_number.toString()
                PrefUtil.setRed2(red_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_2")
            }
        }
        binding.btn3RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_3_number++
                num_side_deck++
                binding.tv3Red?.text = red_3_number.toString()
                PrefUtil.setRed3(red_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_3"
            }
        }
        binding.btn3RedDown?.setOnClickListener {
            if (red_3_number > 0) {
                red_3_number--
                num_side_deck--
                binding.tv3Red?.text = red_3_number.toString()
                PrefUtil.setRed3(red_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_3")
            }
        }
        binding.btn4RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_4_number++
                num_side_deck++
                binding.tv4Red?.text = red_4_number.toString()
                PrefUtil.setRed4(red_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_4"
            }
        }
        binding.btn4RedDown?.setOnClickListener {
            if (red_4_number > 0) {
                red_4_number--
                num_side_deck--
                binding.tv4Red?.text = red_4_number.toString()
                PrefUtil.setRed4(red_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_4")
            }
        }
        binding.btn5RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_5_number++
                num_side_deck++
                binding.tv5Red?.text = red_5_number.toString()
                PrefUtil.setRed5(red_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_5"
            }
        }
        binding.btn5RedDown?.setOnClickListener {
            if (red_5_number > 0) {
                red_5_number--
                num_side_deck--
                binding.tv5Red?.text = red_5_number.toString()
                PrefUtil.setRed5(red_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_5")
            }
        }
        binding.btn6RedUp?.setOnClickListener {
            if (num_side_deck < 10) {
                red_6_number++
                num_side_deck++
                binding.tv6Red?.text = red_6_number.toString()
                PrefUtil.setRed6(red_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "red_6"
            }
        }
        binding.btn6RedDown?.setOnClickListener {
            if (red_6_number > 0) {
                red_6_number--
                num_side_deck--
                binding.tv6Red?.text = red_6_number.toString()
                PrefUtil.setRed6(red_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("red_6")
            }
        }

        binding.btn1BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_1_number++
                num_side_deck++
                binding.tv1BlueFlip?.text = blue_flip_1_number.toString()
                PrefUtil.setBlueFlip1(blue_flip_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_1"
            }
        }
        binding.btn1BlueFlipDown?.setOnClickListener {
            if (blue_flip_1_number > 0) {
                blue_flip_1_number--
                num_side_deck--
                binding.tv1BlueFlip?.text = blue_flip_1_number.toString()
                PrefUtil.setBlueFlip1(blue_flip_1_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_1")
            }
        }
        binding.btn2BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_2_number++
                num_side_deck++
                binding.tv2BlueFlip?.text = blue_flip_2_number.toString()
                PrefUtil.setBlueFlip2(blue_flip_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_2"
            }
        }
        binding.btn2BlueFlipDown?.setOnClickListener {
            if (blue_flip_2_number > 0) {
                blue_flip_2_number--
                num_side_deck--
                binding.tv2BlueFlip?.text = blue_flip_2_number.toString()
                PrefUtil.setBlueFlip2(blue_flip_2_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_2")
            }
        }
        binding.btn3BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_3_number++
                num_side_deck++
                binding.tv3BlueFlip?.text = blue_flip_3_number.toString()
                PrefUtil.setBlueFlip3(blue_flip_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_3"
            }
        }
        binding.btn3BlueFlipDown?.setOnClickListener {
            if (blue_flip_3_number > 0) {
                blue_flip_3_number--
                num_side_deck--
                binding.tv3BlueFlip?.text = blue_flip_3_number.toString()
                PrefUtil.setBlueFlip3(blue_flip_3_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_3")
            }
        }
        binding.btn4BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_4_number++
                num_side_deck++
                binding.tv4BlueFlip?.text = blue_flip_4_number.toString()
                PrefUtil.setBlueFlip4(blue_flip_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_4"
            }
        }
        binding.btn4BlueFlipDown?.setOnClickListener {
            if (blue_flip_4_number > 0) {
                blue_flip_4_number--
                num_side_deck--
                binding.tv4BlueFlip?.text = blue_flip_4_number.toString()
                PrefUtil.setBlueFlip4(blue_flip_4_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_4")
            }
        }
        binding.btn5BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_5_number++
                num_side_deck++
                binding.tv5BlueFlip?.text = blue_flip_5_number.toString()
                PrefUtil.setBlueFlip5(blue_flip_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_5"
            }
        }
        binding.btn5BlueFlipDown?.setOnClickListener {
            if (blue_flip_5_number > 0) {
                blue_flip_5_number--
                num_side_deck--
                binding.tv5BlueFlip?.text = blue_flip_5_number.toString()
                PrefUtil.setBlueFlip5(blue_flip_5_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_5")
            }
        }
        binding.btn6BlueFlipUp?.setOnClickListener {
            if (num_side_deck < 10) {
                blue_flip_6_number++
                num_side_deck++
                binding.tv6BlueFlip?.text = blue_flip_6_number.toString()
                PrefUtil.setBlueFlip6(blue_flip_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck += "blue_flip_6"
            }
        }
        binding.btn6BlueFlipDown?.setOnClickListener {
            if (blue_flip_6_number > 0) {
                blue_flip_6_number--
                num_side_deck--
                binding.tv6BlueFlip?.text = blue_flip_6_number.toString()
                PrefUtil.setBlueFlip6(blue_flip_6_number, this)
                PrefUtil.setNumSideDeck(num_side_deck, this)
                player_side_deck.remove("blue_flip_6")
            }
        }

        binding.btnStart?.setOnClickListener {
            if (num_side_deck == 10){
                player_side_deck_array = player_side_deck.toTypedArray()
                PrefUtil.setPlayerSideDeck(player_side_deck_array, this)
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Select 10 side deck cards", Toast.LENGTH_SHORT).show()
            }
        }



    }
    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}