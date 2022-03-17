package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ4Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q4

class Q4 : Fragment() {
    private var _binding: FragmentQ4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ4Binding.inflate(inflater, container, false)

        val fragment4 = binding.root

        binding.nextButton4.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q4 = points

                Navigation.findNavController(fragment4)
                    .navigate(R.id.action_q4_to_q5)
            }
        }
        return fragment4
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup4.checkedRadioButtonId) {
            binding.q4a.id -> 0
            binding.q4b.id -> 2
            binding.q4c.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}