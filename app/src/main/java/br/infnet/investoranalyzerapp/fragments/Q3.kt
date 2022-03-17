package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ3Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q3

class Q3 : Fragment() {
    private var _binding: FragmentQ3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ3Binding.inflate(inflater, container, false)

        val fragment3 = binding.root

        binding.nextButton3.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q3 = points

                Navigation.findNavController(fragment3)
                    .navigate(R.id.action_q3_to_q4)
            }
        }
        return fragment3
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup3.checkedRadioButtonId) {
            binding.q3a.id -> 0
            binding.q3b.id -> 1
            binding.q3c.id -> 2
            binding.q3d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}