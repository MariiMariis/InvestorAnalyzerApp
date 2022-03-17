package br.infnet.investoranalyzerapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.infnet.investoranalyzerapp.*
import br.infnet.investoranalyzerapp.databinding.ActivityResultBinding
import java.util.*

class ResultActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityResultBinding
    var binding: ActivityResultBinding
        get() = _binding
        set(value) {
            _binding = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        ActivityResultBinding.inflate(layoutInflater).also { binding = it }
        setContentView(binding.root)

        userName.uppercase(Locale.getDefault()).also { binding.investorName.text = it }
        "Perfil de investimentos: ${profileResult()}!".also { binding.investorProfile.text = it }

        punctuation = 0

        binding.restartButton.setOnClickListener {
            val showIntent = Intent(this, MainActivity::class.java)
            startActivity(showIntent)
        }
    }

    private fun profileResult(): String {
        val points = punctuation
        if (points <= 12) {
            return "CONSERVADOR \n $points pontos"
        } else if (points in 13..29) {
            return "MODERADO \n $points pontos" }
        return "ARROJADO \n $points pontos"
    }
}