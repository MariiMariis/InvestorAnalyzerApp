package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ6Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q6

class Q6 : Fragment() {
    private var _binding: FragmentQ6Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ6Binding.inflate(inflater, container, false)

        val fragment6 = binding.root

        binding.nextButton6.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q6 = points

                Navigation.findNavController(fragment6)
                    .navigate(R.id.action_q6_to_q7)
            }
        }
        return fragment6
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup6.checkedRadioButtonId) {
            binding.q6a.id -> 0
            binding.q6b.id -> 2
            binding.q6c.id -> 3
            binding.q6d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}