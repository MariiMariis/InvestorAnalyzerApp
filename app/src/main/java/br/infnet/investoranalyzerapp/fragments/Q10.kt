package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ10Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q1

class Q10 : Fragment() {
    private var _binding: FragmentQ10Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ10Binding.inflate(inflater, container, false)

        val fragment10 = binding.root

        binding.nextButton10.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q1 = points

                Navigation.findNavController(fragment10)
                    .navigate(R.id.action_q10_to_q11)
            }
        }
        return fragment10
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup10.checkedRadioButtonId) {
            binding.q10a.id -> 0
            binding.q10b.id -> 1
            binding.q10c.id -> 2
            binding.q10d.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}