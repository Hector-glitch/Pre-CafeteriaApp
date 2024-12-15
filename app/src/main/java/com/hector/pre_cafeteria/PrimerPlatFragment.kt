package com.hector.pre_cafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hector.pre_cafeteria.databinding.FragmentPrimerPlatBinding

class PrimerPlat : Fragment() {
    private lateinit var binding: FragmentPrimerPlatBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPrimerPlatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        binding.buttonNext1.setOnClickListener {
            val nom = binding.editTextNomPlat.text.toString()
            val quantitat = binding.editTextQuantitat.text.toString().toIntOrNull() ?: 0
            val preu = binding.editTextPreu.text.toString().toDoubleOrNull() ?: 0.0

            viewModel.savePrimerPlat(nom, quantitat, preu)
            findNavController().navigate(R.id.action_primerPlat_to_begudes)
        }
    }
}
