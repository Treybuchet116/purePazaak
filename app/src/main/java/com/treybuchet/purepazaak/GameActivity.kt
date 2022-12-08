package com.treybuchet.purepazaak

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.treybuchet.purepazaak.databinding.ActivityGameBinding
import com.treybuchet.purepazaak.util.PrefUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class GameActivity : AppCompatActivity() {

    private var pStand = false
    private var comStand = false
    private var pCardsPlayed = 0
    private var comCardsPlayed = 0
    private var pScore = 0
    private var comScore = 0
    private var playerStars = 0F
    private var comStars = 0F
    private var pBomb = false
    private var comBomb = false
    private var sideEnabled = true
    private var deckContents = listOf(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,
        4, 4, 4, 4, 4,5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8,
        9, 9, 9, 9, 9, 10, 10, 10, 10, 10)
    private var alreadyScored = false

    private lateinit var com_side_hand: List<Int>
    private lateinit var binding: ActivityGameBinding
    private var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cardNames = listOf("blank", "blue_1", "blue_2", "blue_3", "blue_4", "blue_5", "blue_6", "red_1", "red_2", "red_3", "red_4", "red_5", "red_6", "blue_flip_1", "blue_flip_2", "blue_flip_3", "blue_flip_4", "blue_flip_5", "blue_flip_6")
        val cardNamesFull = listOf("blank", "blue_1", "blue_2", "blue_3", "blue_4", "blue_5", "blue_6", "red_1", "red_2", "red_3", "red_4", "red_5", "red_6", "blue_flip_1", "blue_flip_2", "blue_flip_3", "blue_flip_4", "blue_flip_5", "blue_flip_6", "red_flip_1", "red_flip_2", "red_flip_3", "red_flip_4", "red_flip_5", "red_flip_6")
        val sideValues = listOf(0, 1, 2, 3, 4, 5, 6, -1, -2, -3, -4, -5, -6, 1, 2, 3, 4, 5, 6, -1, -2, -3, -4, -5, -6)
        val cardImages = listOf(R.drawable.cardblank, R.drawable.card1blue, R.drawable.card2blue, R.drawable.card3blue, R.drawable.card4blue, R.drawable.card5blue, R.drawable.card6blue, R.drawable.card1red, R.drawable.card2red, R.drawable.card3red, R.drawable.card4red, R.drawable.card5red, R.drawable.card6red, R.drawable.card1blueflip, R.drawable.card2blueflip, R.drawable.card3blueflip, R.drawable.card4blueflip, R.drawable.card5blueflip, R.drawable.card6blueflip, R.drawable.card1redflip, R.drawable.card2redflip, R.drawable.card3redflip, R.drawable.card4redflip, R.drawable.card5redflip, R.drawable.card6redflip)
        val deckImages = listOf(R.drawable.cardblank, R.drawable.card1green, R.drawable.card2green, R.drawable.card3green, R.drawable.card4green, R.drawable.card5green, R.drawable.card6green, R.drawable.card7green, R.drawable.card8green, R.drawable.card9green, R.drawable.card10green)
        var comSideDeck = listOf( -6, -6, -5, -5, -4, -4, -3, -3, -2, -2, -1, -1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6)
        var comSideDeckImages = listOf(R.drawable.card1blue, R.drawable.card2blue, R.drawable.card3blue, R.drawable.card4blue, R.drawable.card5blue, R.drawable.card6blue, R.drawable.card6red, R.drawable.card5red, R.drawable.card4red, R.drawable.card3red, R.drawable.card2red, R.drawable.card1red)
        val comSideDeckImageIndex = listOf(1, 2, 3, 4, 5, 6, -6, -5, -4, -3, -2, -1)
        val pBoard = listOf(binding.pHand1, binding.pHand2, binding.pHand3, binding.pHand4, binding.pHand5, binding.pHand6, binding.pHand7, binding.pHand8, binding.pHand9)
        val comBoard = listOf(binding.comHand1, binding.comHand2, binding.comHand3, binding.comHand4, binding.comHand5, binding.comHand6, binding.comHand7, binding.comHand8, binding.comHand9)
        val comSideHand = listOf(binding.comSideHand1, binding.comSideHand2, binding.comSideHand3, binding.comSideHand4)


        var side1Used = false
        var side2Used = false
        var side3Used = false
        var side4Used = false
        var comSideUsed = arrayOf(false, false, false, false)
        val globalWin = PrefUtil.getGlobalWin(this)
        val globalLoss = PrefUtil.getGlobalLoss(this)


        val player_side_deck = PrefUtil.getPlayerSideDeck(this)


        fun comSideHand(sideDeck: List<Int>): List<Int>{
            var comSide = emptyList<Int>()
            var sideDeck = sideDeck
            while (comSide.size < 4){
                val index = randomNumber(sideDeck.size)
                val new_card = sideDeck[index]
                comSide += new_card!!
                sideDeck -= new_card
            }
            comSide = comSide.sortedDescending()
            return comSide
        }

        fun drawSideHand(side_deck: Array<String?>): Array<String> {
            var side_hand = mutableListOf<String>()
            var sideDeck = side_deck.toMutableList()
            while (side_hand.size < 4){
                val index = randomNumber(sideDeck.size)
                val new_card = sideDeck[index]
                side_hand += new_card!!
                sideDeck -= new_card

            }
            val side_hand_array = side_hand.toTypedArray()
            return side_hand_array
        }
        val player_side_hand = drawSideHand(player_side_deck)
        com_side_hand = comSideHand(comSideDeck)

        var cardIndexes = emptyList<Int>()
        for (cardName in player_side_hand){
            val index = cardNames.indexOf(cardName)
            cardIndexes += index
        }

        binding.pSideHand1.setImageResource(cardImages[cardIndexes[0]])
        binding.pSideHand2.setImageResource(cardImages[cardIndexes[1]])
        binding.pSideHand3.setImageResource(cardImages[cardIndexes[2]])
        binding.pSideHand4.setImageResource(cardImages[cardIndexes[3]])
        binding.tvComScore.text = comScore.toString()
        binding.tvPScore.text = pScore.toString()


        binding.btnHit.setOnClickListener {
            disablePlayer()
            CoroutineScope(Main).launch {
                if (pScore > 20) {
                    pStand = true
                    pBomb = true
                    if (!alreadyScored) {
                        alreadyScored = true
                        scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                    }
                }else if (pCardsPlayed == 9){
                    pStand = true
                    if (pStand && comStand && !alreadyScored){
                        alreadyScored = true
                        scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                    }
                }else {
                    if (!comStand) {
                        comDrawCard(comBoard, deckImages)
                        binding.tvComScore.text = comScore.toString()
                        comTurn(
                            comBoard,
                            comSideDeckImages,
                            comSideDeckImageIndex,
                            comSideHand,
                            comSideUsed, pBoard, deckImages, globalWin, globalLoss
                        )
                        binding.tvComScore.text = comScore.toString()
                        if (comScore > 20 && !alreadyScored){
                            alreadyScored = true
                            comStand = true
                            comBomb = true
                            scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                        }
                    }
                    pDrawCard(pBoard, deckImages)
                    binding.tvPScore.text = pScore.toString()
                    if (pStand && comStand && !alreadyScored) {
                        alreadyScored = true
                        scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                    }
                    enablePlayer()
                    sideEnabled = true
                }
            }
        }

        binding.btnStand.setOnClickListener {
            disablePlayer()
            pStand = true
            if (pStand && comStand && !alreadyScored) {
                alreadyScored = true
                scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
            }
            CoroutineScope(Main).launch {
                if (pScore > 20 && !alreadyScored) {
                    pStand = true
                    pBomb = true
                    alreadyScored = true
                    scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                }else{
                    pStand = true
                    while (!comStand) {
                        comDrawCard(comBoard, deckImages)
                        binding.tvComScore.text = comScore.toString()
                        comTurn(comBoard, comSideDeckImages, comSideDeckImageIndex, comSideHand, comSideUsed, pBoard, deckImages, globalWin, globalLoss)
                        binding.tvComScore.text = comScore.toString()
                        if (comScore >= 20 && !alreadyScored){
                            alreadyScored = true
                            comStand = true
                            comBomb = true
                            scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                        }

                    }

                }
                if (!pBomb && !alreadyScored) {
                    alreadyScored = true
                    scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
                }
            }

        }

        binding.btnFlip.setOnClickListener {
            flipHandCards(player_side_hand, cardNamesFull, cardImages)
        }

        binding.pSideHand1.setOnClickListener{
            if (binding.btnHit.isEnabled && sideEnabled && !side1Used){
                try {
                    if (player == null) {
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }else{
                        player?.reset()
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                val cardName = player_side_hand[0]
                val index = cardNamesFull.indexOf(cardName)
                pBoard[pCardsPlayed].setImageResource(cardImages[index])
                pScore += sideValues[index]
                binding.tvPScore.text = pScore.toString()
                binding.pSideHand1.setImageResource(R.drawable.cardblank)
                pCardsPlayed += 1
                sideEnabled = false
                side1Used = true
                player_side_hand[0] = "blank"
                if (pCardsPlayed == 9){
                    pStand = true
                }
            }
        }

        binding.pSideHand2.setOnClickListener{
            if (binding.btnHit.isEnabled && sideEnabled && !side2Used){
                try {
                    if (player == null) {
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }else{
                        player?.reset()
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                val cardName = player_side_hand[1]
                val index = cardNamesFull.indexOf(cardName)
                pBoard[pCardsPlayed].setImageResource(cardImages[index])
                pScore += sideValues[index]
                binding.tvPScore.text = pScore.toString()
                binding.pSideHand2.setImageResource(R.drawable.cardblank)
                pCardsPlayed += 1
                sideEnabled = false
                side2Used = true
                player_side_hand[1] = "blank"
                if (pCardsPlayed == 9){
                    pStand = true
                }
            }
        }

        binding.pSideHand3.setOnClickListener{
            if (binding.btnHit.isEnabled && sideEnabled && !side3Used){
                try {
                    if (player == null) {
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }else{
                        player?.reset()
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                val cardName = player_side_hand[2]
                val index = cardNamesFull.indexOf(cardName)
                pBoard[pCardsPlayed].setImageResource(cardImages[index])
                pScore += sideValues[index]
                binding.tvPScore.text = pScore.toString()
                binding.pSideHand3.setImageResource(R.drawable.cardblank)
                pCardsPlayed += 1
                sideEnabled = false
                side3Used = true
                player_side_hand[2] = "blank"
                if (pCardsPlayed == 9){
                    pStand = true
                }
            }
        }

        binding.pSideHand4.setOnClickListener{
            if (binding.btnHit.isEnabled && sideEnabled && !side4Used){
                try {
                    if (player == null) {
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }else{
                        player?.reset()
                        player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                        player?.isLooping = false
                        player?.start()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                val cardName = player_side_hand[3]
                val index = cardNamesFull.indexOf(cardName)
                pBoard[pCardsPlayed].setImageResource(cardImages[index])
                pScore += sideValues[index]
                binding.tvPScore.text = pScore.toString()
                binding.pSideHand4.setImageResource(R.drawable.cardblank)
                pCardsPlayed += 1
                sideEnabled = false
                side4Used = true
                player_side_hand[3] = "blank"
                if (pCardsPlayed == 9){
                    pStand = true
                }
            }
        }
        CoroutineScope(Main).launch {
            pDrawCard(pBoard, deckImages)
            binding.tvPScore.text = pScore.toString()
        }


    }


    private suspend fun pDrawCard(board: List<ImageView>, deckImages: List<Int>){
        try {
            if (player == null) {
                player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                player?.isLooping = false
                player?.start()
            }else{
                player?.reset()
                player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                player?.isLooping = false
                player?.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        delay(500)
        val index = randomNumber(deckContents.size)
        val newCard = deckContents[index]
        pScore += newCard
        deckContents -= newCard
        board[pCardsPlayed].setImageResource(deckImages[newCard])
        pCardsPlayed += 1
        binding.tvPScore.text = pScore.toString()
        if (pCardsPlayed == 9){
            pStand = true
        }
    }
    private suspend fun comDrawCard(board: List<ImageView>, deckImages: List<Int>){
        try {
            if (player == null) {
                player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                player?.isLooping = false
                player?.start()
            }else{
                player?.reset()
                player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                player?.isLooping = false
                player?.start()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        delay(500)
        val index = randomNumber(deckContents.size)
        val newCard = deckContents[index]
        comScore += newCard
        deckContents -= newCard
        board[comCardsPlayed].setImageResource(deckImages[newCard])
        comCardsPlayed += 1
        if (comCardsPlayed == 9){
            comStand = true
        }
    }

    private fun enablePlayer(){
        binding.btnHit.isEnabled = true
        binding.btnStand.isEnabled = true
    }

    private fun disablePlayer(){
        binding.btnHit.isEnabled = false
        binding.btnStand.isEnabled = false
    }


    private suspend fun comTurn(comBoard: List<ImageView>, comSideDeckImages: List<Int>, comSideDeckImageIndex: List<Int>, comSideHand: List<ImageView>, comSideUsed: Array<Boolean>, pBoard: List<ImageView>, deckImages: List<Int>, globalWin: Int, globalLoss: Int){
        var sideHandPlayed = false
        binding.btnComHit.isEnabled = true
        binding.btnComStand.isEnabled = true

        if (comScore > 20){
        var sideIndex = 0
            for (card in com_side_hand) {
                if (comScore + card <= 20 && !comSideUsed[sideIndex] && !sideHandPlayed) {
                    try {
                        if (player == null) {
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }else{
                            player?.reset()
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    delay(500)
                    val index = comSideDeckImageIndex.indexOf(card)
                    comBoard[comCardsPlayed].setImageResource(comSideDeckImages[index])
                    comSideHand[sideIndex].setImageResource(R.drawable.cardblank)
                    comSideUsed[sideIndex] = true
                    comScore += card
                    comCardsPlayed += 1
                    sideHandPlayed = true
                }
                sideIndex += 1
            }
        }else if (comScore == 20) {
            comStand = true
        }else if (pStand && comScore > pScore){
            comStand = true
        }else if (comScore > 17){
            var sideIndex = 0
            for (card in com_side_hand){
                if (comScore + card <=20 && card > 0 && !comSideUsed[sideIndex] && !sideHandPlayed) {
                    try {
                        if (player == null) {
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }else{
                            player?.reset()
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    delay(500)
                    val index = comSideDeckImageIndex.indexOf(card)
                    comBoard[comCardsPlayed].setImageResource(comSideDeckImages[index])
                    comSideHand[sideIndex].setImageResource(R.drawable.cardblank)
                    comSideUsed[sideIndex] = true
                    comScore += card
                    comCardsPlayed += 1
                    sideHandPlayed = true
                }
                sideIndex += 1
            }
        }else {
            var sideIndex = 0
            for (card in com_side_hand) {
                if (comScore + card == 20 && !comSideUsed[sideIndex] && !sideHandPlayed) {
                    try {
                        if (player == null) {
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }else{
                            player?.reset()
                            player = MediaPlayer.create(this@GameActivity, R.raw.squirt_1_trimmed)
                            player?.isLooping = false
                            player?.start()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    delay(500)
                    val index = comSideDeckImageIndex.indexOf(card)
                    comBoard[comCardsPlayed].setImageResource(comSideDeckImages[index])
                    comSideHand[sideIndex].setImageResource(R.drawable.cardblank)
                    comSideUsed[sideIndex] = true
                    comScore += card
                    comCardsPlayed += 1
                    sideHandPlayed = true
                }
                sideIndex += 1
            }
        }
        delay(500)
        if (!comStand){
            if (comScore >= 17 && comScore >= pScore) {
                comStand = true
                binding.btnComHit.isEnabled = false
            }else if (comScore >= 20){
                comStand = true
                binding.btnComHit.isEnabled = false
            }else if (comCardsPlayed == 9) {
                comStand = true
                binding.btnComHit.isEnabled = false
            }else{
                binding.btnComStand.isEnabled = false
            }

        }else{
            binding.btnComHit.isEnabled = false
        }
        if (pStand && comStand && !alreadyScored) {
            alreadyScored = true
            scoreSet(pBoard, comBoard, deckImages, globalWin, globalLoss)
        }
    }

    private fun scoreSet(pBoard: List<ImageView>, comBoard: List<ImageView>, deckImages: List<Int>, globalWin: Int, globalLoss: Int){
        var globalWin = globalWin
        var globalLoss = globalLoss

        var winner = "Tie"
        if (pScore > 20){
            winner = "Opponent wins"
        }else if (comScore > 20){
            winner = "You win"
        }else if (comScore > pScore){
            winner = "Opponent wins"
        }else if (pScore > comScore){
            winner = "You win"
        }
        if (winner == "You win"){
            playerStars += 1
            if (playerStars < 3F){
                try {
                    player?.reset()
                    player = MediaPlayer.create(this@GameActivity, R.raw.tone_4_trimmed)
                    player?.isLooping = false
                    player?.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }else if (winner == "Opponent wins"){
            comStars += 1
            if (comStars < 3F){
                try {
                    player?.reset()
                    player = MediaPlayer.create(this@GameActivity, R.raw.tone_3_trimmed)
                    player?.isLooping = false
                    player?.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        binding.pSetWins.rating = playerStars
        binding.comSetWins.rating = comStars

        if (playerStars == 3F || comStars == 3F){
            if (playerStars == 3F){
                try {
                    player = MediaPlayer.create(this@GameActivity, R.raw.tone_2_trimmed)
                    player?.isLooping = false
                    player?.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                globalWin += 1
                PrefUtil.setGlobalWin(globalWin, this)
            }else if (comStars == 3F){
                try {
                    player = MediaPlayer.create(this@GameActivity, R.raw.tone_1_trimmed)
                    player?.isLooping = false
                    player?.start()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                globalLoss += 1
                PrefUtil.setGlobalLoss(globalLoss, this)
            }
            MaterialAlertDialogBuilder(this)
                .setTitle("Round over!!")
                .setMessage(winner)
                .setPositiveButton("Okay",
                    DialogInterface.OnClickListener { dialog, which ->
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    })
                .show()


        }else {
            MaterialAlertDialogBuilder(this)
                .setTitle("Set over!!")
                .setMessage(winner)
                .setPositiveButton("Okay",
                    DialogInterface.OnClickListener { dialog, which ->
                    })
                .setOnDismissListener{resetBoard(pBoard, comBoard, deckImages)}
                .show()
        }
    }

    private fun resetBoard(pBoard: List<ImageView>, comBoard: List<ImageView>, deckImages: List<Int>){
        alreadyScored = false
        for (card in pBoard){
            card.setImageResource(R.drawable.cardblank)
        }
        for (card in comBoard){
            card.setImageResource(R.drawable.cardblank)
        }
        pScore = 0
        comScore = 0
        pCardsPlayed = 0
        comCardsPlayed = 0
        pStand = false
        comStand = false
        binding.tvComScore.text = comScore.toString()
        binding.tvPScore.text = pScore.toString()
        deckContents = listOf(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10)


        CoroutineScope(Main).launch {
            pDrawCard(pBoard, deckImages)
        }
        sideEnabled = true
        enablePlayer()
    }

    private fun randomNumber(range: Int): Int{
        val randomZeroToOne = Math.random()
        val randomNumber = randomZeroToOne * range
        val randomInt = randomNumber.toInt()
        return randomInt
    }

    private fun flipHandCards(player_side_hand: Array<String>, cardNamesFull: List<String>, cardImages: List<Int>){
        var new_player_side_hand = player_side_hand
        for (card in player_side_hand){
            when (card) {
                "blue_flip_1" -> {
                    val index = player_side_hand.indexOf("blue_flip_1")
                    new_player_side_hand[index] = "red_flip_1"
                }
                "blue_flip_2" -> {
                    val index = player_side_hand.indexOf("blue_flip_2")
                    new_player_side_hand[index] = "red_flip_2"
                }
                "blue_flip_3" -> {
                    val index = player_side_hand.indexOf("blue_flip_3")
                    new_player_side_hand[index] = "red_flip_3"
                }
                "blue_flip_4" -> {
                    val index = player_side_hand.indexOf("blue_flip_4")
                    new_player_side_hand[index] = "red_flip_4"
                }
                "blue_flip_5" -> {
                    val index = player_side_hand.indexOf("blue_flip_5")
                    new_player_side_hand[index] = "red_flip_5"
                }
                "blue_flip_6" -> {
                    val index = player_side_hand.indexOf("blue_flip_6")
                    new_player_side_hand[index] = "red_flip_6"
                }
                "red_flip_1" -> {
                    val index = player_side_hand.indexOf("red_flip_1")
                    new_player_side_hand[index] = "blue_flip_1"
                }
                "red_flip_2" -> {
                    val index = player_side_hand.indexOf("red_flip_2")
                    new_player_side_hand[index] = "blue_flip_2"
                }
                "red_flip_3" -> {
                    val index = player_side_hand.indexOf("red_flip_3")
                    new_player_side_hand[index] = "blue_flip_3"
                }
                "red_flip_4" -> {
                    val index = player_side_hand.indexOf("red_flip_4")
                    new_player_side_hand[index] = "blue_flip_4"
                }
                "red_flip_5" -> {
                    val index = player_side_hand.indexOf("red_flip_5")
                    new_player_side_hand[index] = "blue_flip_5"
                }
                "red_flip_6" -> {
                    val index = player_side_hand.indexOf("red_flip_6")
                    new_player_side_hand[index] = "blue_flip_6"
                }
            }

        }
        var cardIndexes = emptyList<Int>()
        for (cardName in player_side_hand){
            val index = cardNamesFull.indexOf(cardName)
            cardIndexes += index
        }

        binding.pSideHand1.setImageResource(cardImages[cardIndexes[0]])
        binding.pSideHand2.setImageResource(cardImages[cardIndexes[1]])
        binding.pSideHand3.setImageResource(cardImages[cardIndexes[2]])
        binding.pSideHand4.setImageResource(cardImages[cardIndexes[3]])
    }


    override fun onBackPressed() {
    }


}