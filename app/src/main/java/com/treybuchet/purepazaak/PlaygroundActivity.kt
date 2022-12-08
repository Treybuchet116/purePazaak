package com.treybuchet.purepazaak

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.treybuchet.purepazaak.databinding.ActivityPlaygroundBinding
import com.treybuchet.purepazaak.util.PrefUtil
import java.util.*

class PlaygroundActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaygroundBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaygroundBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val cardNames = listOf("blue_1", "blue_2", "blue_3", "blue_4", "blue_5", "blue_6", "red_1", "red_2", "red_3", "red_4", "red_5", "red_6", "blue_flip_1", "blue_flip_2", "blue_flip_3", "blue_flip_4", "blue_flip_5", "blue_flip_6")
//        val cardImages = listOf(R.drawable.card1blue, R.drawable.card2blue, R.drawable.card3blue, R.drawable.card4blue, R.drawable.card5blue, R.drawable.card6blue, R.drawable.card1red, R.drawable.card2red, R.drawable.card3red, R.drawable.card4red, R.drawable.card5red, R.drawable.card6red, R.drawable.card1blueflip, R.drawable.card2blueflip, R.drawable.card3blueflip, R.drawable.card4blueflip, R.drawable.card5blueflip, R.drawable.card6blueflip)
//
//        val player_side_deck = PrefUtil.getPlayerSideDeck(this)
////        val player_side_deck = intent.getStringArrayExtra("PLAYER_SIDE_DECK")
//
//        fun drawSideHand(side_deck: Array<String?>): Array<String> {
//            var side_hand = mutableListOf<String>()
//            while (side_hand.size < 4){
//                val new_card = side_deck.random()
//                side_hand += new_card!!
//            }
//            val side_hand_array = side_hand.toTypedArray()
//            return side_hand_array
//        }
//        val player_side_hand = drawSideHand(player_side_deck)
//
//        binding.textView.text = player_side_hand.contentToString()
//
//        var cardIndexes = emptyList<Int>()
//        for (cardName in player_side_hand){
//            val index = cardNames.indexOf(cardName)
//            cardIndexes += index
//        }
//        binding.textView3.text = cardIndexes.toString()
//        binding.sideHand1.setImageResource(cardImages[cardIndexes[0]])
//        binding.sideHand2.setImageResource(cardImages[cardIndexes[1]])
//        binding.sideHand3.setImageResource(cardImages[cardIndexes[2]])
//        binding.sideHand4.setImageResource(cardImages[cardIndexes[3]])


    }
}