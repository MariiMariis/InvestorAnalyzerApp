package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ7Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q7

class Q7 : Fragment() {
    private var _binding: FragmentQ7Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ7Binding.inflate(inflater, container, false)

        val fragment7 = binding.root

        binding.nextButton7.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q7 = points

                Navigation.findNavController(fragment7)
                    .navigate(R.id.action_q7_to_q10)
            }
        }
        return fragment7
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup7.checkedRadioButtonId) {
            binding.q7a.id -> 0
            binding.q7b.id -> 2
            binding.q7c.id -> 3
            binding.q7d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}