  package com.example.basicnavigation_p14.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.basicnavigation_p14.R
import com.example.basicnavigation_p14.database.User
import com.example.basicnavigation_p14.databinding.FragmentDestinationBinding
import com.example.basicnavigation_p14.databinding.FragmentLeftBinding


  class LeftFragment : Fragment() {
    private lateinit var binding: FragmentLeftBinding
    private val leftViewModel: LeftViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentLeftBinding.inflate(inflater,container, false)
        val destination = LeftFragmentDirections.actionLeftFragmentToDestinationFragment(binding.etName.text.toString())
        binding.btnSendName.setOnClickListener {

            NavHostFragment.findNavController(this).navigate(destination)
        }
        binding.btnRegister.setOnClickListener {
            leftViewModel.save(User(binding.idUser.text.toString().toInt(), binding.nameUser.text.toString()))
            NavHostFragment.findNavController(this).navigate(destination)
        }
        //for (x in 1..6){
        //leftViewModel.save(User(x,"repleace${x}"))}
        return binding.root
    }


}