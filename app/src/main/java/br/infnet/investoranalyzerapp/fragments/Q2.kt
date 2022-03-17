package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ2Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q2

class Q2 : Fragment() {
    private var _binding: FragmentQ2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ2Binding.inflate(inflater, container, false)

        val fragment2 = binding.root

        binding.nextButton2.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q2 = points

                Navigation.findNavController(fragment2)
                    .navigate(R.id.action_q2_to_q3)
            }
        }
        return fragment2
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup2.checkedRadioButtonId) {
            binding.q2a.id -> 0
            binding.q2b.id -> 2
            binding.q2c.id -> 4
            binding.q2d.id -> 5
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}