 package com.example.basicnavigation_p14.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicnavigation_p14.R
import com.example.basicnavigation_p14.database.User
import com.example.basicnavigation_p14.databinding.FragmentDestinationBinding


 class DestinationFragment : Fragment() {



private lateinit var binding : FragmentDestinationBinding
     private val destinationViewModel: DestinationViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDestinationBinding.inflate(inflater,container,false)
        return binding.root
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         val reciveUsername = arguments?.getString("username_arg")
         binding.tvReveivedArg.setText(reciveUsername)

         binding.rvUserEntries.layoutManager = LinearLayoutManager(view?.context)



         destinationViewModel.getUsers()


         destinationViewModel.savedUsers.observe(viewLifecycleOwner,{userList->
             if (!userList.isNullOrEmpty()) {
                 val adapter = DestinationAdapter(userList)
                 binding.rvUserEntries.adapter = adapter
                 for (saveduser in userList){
                     Log.d("obtaneduser","user ${saveduser.username}")
                 }
             }else{
                 Log.d("obtaneduser","from frakment is null or empy")
             }
         })


     }

}