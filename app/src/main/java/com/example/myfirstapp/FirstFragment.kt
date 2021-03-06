package com.example.myfirstapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the first destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToast.setOnClickListener {
            Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT).show()
        }

        binding.btnRandom.setOnClickListener {
            val currentCount = binding.tvText.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        binding.btnCount.setOnClickListener {
            countMe(view)
        }
    }

    private fun countMe(view: View) {
        val countString = binding.tvText.text.toString()
        var count = countString.toInt()
        count++
        binding.tvText.text = count.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}