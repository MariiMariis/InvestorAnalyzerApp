package br.infnet.investoranalyzerapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.activities.ResultActivity
import br.infnet.investoranalyzerapp.databinding.FragmentQ11Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q11

class Q11 : Fragment() {
    private var _binding: FragmentQ11Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ11Binding.inflate(inflater, container, false)

        val fragment11 = binding.root

        binding.nextButton11.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q11 = points

                val showIntent = Intent(requireContext(), ResultActivity::class.java)
                startActivity(showIntent)
            }
        }

        return fragment11
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup11.checkedRadioButtonId) {
            R.id.q11a -> 0
            R.id.q11b -> 1
            R.id.q11c -> 2
            R.id.q11d -> 4
            R.id.q11e -> 5
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}