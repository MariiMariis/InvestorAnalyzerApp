package br.infnet.investoranalyzerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import br.infnet.investoranalyzerapp.R
import br.infnet.investoranalyzerapp.databinding.FragmentQ5Binding
import br.infnet.investoranalyzerapp.punctuation
import br.infnet.investoranalyzerapp.q5

class Q5 : Fragment() {
    private var _binding: FragmentQ5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQ5Binding.inflate(inflater, container, false)

        val fragment5 = binding.root

        binding.nextButton5.setOnClickListener {
            val points = select()
            punctuation += points
            if (points >= 0) {
                q5 = points

                Navigation.findNavController(fragment5)
                    .navigate(R.id.action_q5_to_q6)
            }
        }
        return fragment5
    }

    private fun select(): Int {
        var points = 0

        points += when (val getId = binding.radioGroup5.checkedRadioButtonId) {
            binding.q5a.id -> 0
            binding.q5b.id -> 2
            binding.q5c.id -> 4
            else -> {
                Toast.makeText(requireContext(), "Selecione uma alternativa para continuar", Toast.LENGTH_SHORT).show()
                return getId
            }
        }
        return points
    }
}