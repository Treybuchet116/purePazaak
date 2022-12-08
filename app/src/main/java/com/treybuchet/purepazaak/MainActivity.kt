package com.treybuchet.purepazaak

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.treybuchet.purepazaak.databinding.ActivityMainBinding
import com.treybuchet.purepazaak.util.PrefUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalWins = PrefUtil.getGlobalWin(this)
        val totalLosses = PrefUtil.getGlobalLoss(this)



        binding.button?.setOnClickListener{
            val intent = Intent(this, SideDeckActivity2::class.java)
            startActivity(intent)
        }

        binding.ivTrophyCup?.setOnClickListener{
            MaterialAlertDialogBuilder(this)
                .setTitle("WIN STATS")
                .setMessage("Wins: $totalWins \nLosses: $totalLosses")
                .setPositiveButton("Okay",
                    DialogInterface.OnClickListener { dialog, which ->})
                .show()
        }

    }
}