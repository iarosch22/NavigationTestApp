package com.example.navigationtestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationtestapp.databinding.FragmentFactBinding

class FactFragment : Fragment() {

    private lateinit var binding: FragmentFactBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fact = requireArguments().getString(ARGS_FACT)

        binding.fact.text = fact

        val imageId = when(fact) {
            getString(R.string.app_cat_fact) -> R.drawable.cat
            getString(R.string.app_hamster_fact) -> R.drawable.hamster
            else -> -1
        }

        binding.imageButton.setOnClickListener {
            findNavController().navigate(R.id.action_factFragment_to_imageFragment, ImageFragment.createArgs(imageId))
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    companion object {
        const val ARGS_FACT = "fact"

        fun createArgs(fact: String): Bundle = bundleOf(ARGS_FACT to fact)
    }

}