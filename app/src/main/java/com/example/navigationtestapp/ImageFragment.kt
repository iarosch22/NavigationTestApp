package com.example.navigationtestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationtestapp.databinding.FragmentImageBinding

class ImageFragment: Fragment() {

    private lateinit var binding: FragmentImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.image.setImageResource(requireArguments().getInt(ARGS_IMAGE))

        binding.goToStartButton.setOnClickListener {
            findNavController().popBackStack(R.id.startFragment, false)
        }

        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.image.animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        binding.image.animate()

    }

    companion object {
        private const val ARGS_IMAGE = "image"

        fun createArgs(imageResId: Int): Bundle = bundleOf(ARGS_IMAGE to imageResId)
    }

}