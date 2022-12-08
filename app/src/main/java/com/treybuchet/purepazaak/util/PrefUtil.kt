package com.treybuchet.purepazaak.util

import android.content.Context
import androidx.preference.PreferenceManager


class PrefUtil {
    companion object{


//        private const val PLAYER_SIDE_DECK_ID= "com.treybuchet.purepazaak.player_side_deck"
//
//        fun getPlayerSideDeck(context: Context): Int{
//            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
//            return preferences.getInt(NUM_SIDE_DECK_ID, 0)
//        }
//
//        fun setPlayerSideDeck(cards: Int, context: Context){
//            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
//            editor.putInt(NUM_SIDE_DECK_ID, cards)
//            editor.apply()
//        }

        fun setPlayerSideDeck(sideDeck: Array<String?>, mContext: Context): Boolean {
            val preferences = mContext.getSharedPreferences("preferencename", 0)
            val editor = preferences.edit()
            editor.putInt("playerSideDeck" + "_size", sideDeck.size)
            for (i in sideDeck.indices) editor.putString("playerSideDeck_$i", sideDeck[i])
            return editor.commit()
        }
        fun getPlayerSideDeck(mContext: Context): Array<String?> {
            val preferences = mContext.getSharedPreferences("preferencename", 0)
            val size = preferences.getInt("playerSideDeck" + "_size", 0)
            val array = arrayOfNulls<String>(size)
            for (i in 0 until size) array[i] = preferences.getString("playerSideDeck_$i", "blue_1")
            return array

        }

        private const val GLOBAL_WIN_ID = "com.treybuchet.purepazaak.global_win"

        fun getGlobalWin(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(GLOBAL_WIN_ID, 0)
        }

        fun setGlobalWin(wins: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(GLOBAL_WIN_ID, wins)
            editor.apply()
        }

        private const val GLOBAL_LOSS_ID = "com.treybuchet.purepazaak.global_loss"

        fun getGlobalLoss(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(GLOBAL_LOSS_ID, 0)
        }

        fun setGlobalLoss(losses: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(GLOBAL_LOSS_ID, losses)
            editor.apply()
        }


        private const val NUM_SIDE_DECK_ID = "com.treybuchet.purepazaak.num_side_deck"

        fun getNumSideDeck(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(NUM_SIDE_DECK_ID, 0)
        }

        fun setNumSideDeck(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(NUM_SIDE_DECK_ID, cards)
            editor.apply()
        }

        private const val BLUE_1_ID = "com.treybuchet.purepazaak.blue_1"

        fun getBlue1(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_1_ID, 0)
        }

        fun setBlue1(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_1_ID, cards)
            editor.apply()
        }

        private const val BLUE_2_ID = "com.treybuchet.purepazaak.blue_2"

        fun getBlue2(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_2_ID, 0)
        }

        fun setBlue2(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_2_ID, cards)
            editor.apply()
        }

        private const val BLUE_3_ID = "com.treybuchet.purepazaak.blue_3"

        fun getBlue3(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_3_ID, 0)
        }

        fun setBlue3(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_3_ID, cards)
            editor.apply()
        }

        private const val BLUE_4_ID = "com.treybuchet.purepazaak.blue_4"

        fun getBlue4(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_4_ID, 0)
        }

        fun setBlue4(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_4_ID, cards)
            editor.apply()
        }

        private const val BLUE_5_ID = "com.treybuchet.purepazaak.blue_5"

        fun getBlue5(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_5_ID, 0)
        }

        fun setBlue5(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_5_ID, cards)
            editor.apply()
        }

        private const val BLUE_6_ID = "com.treybuchet.purepazaak.blue_6"

        fun getBlue6(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_6_ID, 0)
        }

        fun setBlue6(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_6_ID, cards)
            editor.apply()
        }


        private const val RED_1_ID = "com.treybuchet.purepazaak.red_1"

        fun getRed1(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_1_ID, 0)
        }

        fun setRed1(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_1_ID, cards)
            editor.apply()
        }

        private const val RED_2_ID = "com.treybuchet.purepazaak.red_2"

        fun getRed2(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_2_ID, 0)
        }

        fun setRed2(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_2_ID, cards)
            editor.apply()
        }

        private const val RED_3_ID = "com.treybuchet.purepazaak.red_3"

        fun getRed3(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_3_ID, 0)
        }

        fun setRed3(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_3_ID, cards)
            editor.apply()
        }

        private const val RED_4_ID = "com.treybuchet.purepazaak.red_4"

        fun getRed4(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_4_ID, 0)
        }

        fun setRed4(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_4_ID, cards)
            editor.apply()
        }

        private const val RED_5_ID = "com.treybuchet.purepazaak.red_5"

        fun getRed5(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_5_ID, 0)
        }

        fun setRed5(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_5_ID, cards)
            editor.apply()
        }

        private const val RED_6_ID = "com.treybuchet.purepazaak.red_6"

        fun getRed6(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(RED_6_ID, 0)
        }

        fun setRed6(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(RED_6_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_1_ID = "com.treybuchet.purepazaak.blue_flip_1"

        fun getBlueFlip1(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_1_ID, 0)
        }

        fun setBlueFlip1(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_1_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_2_ID = "com.treybuchet.purepazaak.blue_flip_2"

        fun getBlueFlip2(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_2_ID, 0)
        }

        fun setBlueFlip2(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_2_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_3_ID = "com.treybuchet.purepazaak.blue_flip_3"

        fun getBlueFlip3(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_3_ID, 0)
        }

        fun setBlueFlip3(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_3_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_4_ID = "com.treybuchet.purepazaak.blue_flip_4"

        fun getBlueFlip4(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_4_ID, 0)
        }

        fun setBlueFlip4(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_4_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_5_ID = "com.treybuchet.purepazaak.blue_flip_5"

        fun getBlueFlip5(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_5_ID, 0)
        }

        fun setBlueFlip5(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_5_ID, cards)
            editor.apply()
        }

        private const val BLUE_FLIP_6_ID = "com.treybuchet.purepazaak.blue_flip_6"

        fun getBlueFlip6(context: Context): Int{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getInt(BLUE_FLIP_6_ID, 0)
        }

        fun setBlueFlip6(cards: Int, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(BLUE_FLIP_6_ID, cards)
            editor.apply()
        }


    }
}