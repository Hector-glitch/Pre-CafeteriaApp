package com.hector.pre_cafeteria

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hector.pre_cafeteria.databinding.FragmentPreuTotalBinding

class PreuTotal : Fragment() {
    private lateinit var binding: FragmentPreuTotalBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPreuTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        viewModel.primerPlat.observe(viewLifecycleOwner) { plat ->
            binding.textViewPrimerPlat.text = plat
        }

        viewModel.preuPlat.observe(viewLifecycleOwner) { preu ->
            binding.preuPlat.text = String.format("%.2f €", preu)
        }

        viewModel.beguda.observe(viewLifecycleOwner) { beguda ->
            binding.TextViewBegudes.text = beguda
        }

        viewModel.preuBeguda.observe(viewLifecycleOwner) { preu ->
            binding.PreuBegudes.text = String.format("%.2f €", preu)
        }

        viewModel.totalPreu.observe(viewLifecycleOwner) { total ->
            binding.textViewTotal.text = String.format("Total: %.2f €", total)
        }
    }
}
