package com.itc.virginmoneydeveloperchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.virginmoneydeveloperchallenge.adapter.RoomAdapter
import com.itc.virginmoneydeveloperchallenge.databinding.FragmentRoomsBinding
import com.itc.virginmoneydeveloperchallenge.util.UIState

class RoomFragment : BaseFragment() {

    private val binding by lazy{
        FragmentRoomsBinding.inflate(layoutInflater)
    }

    private val roomAdapter by lazy{
        RoomAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initRecyclerView()
        observeData()
        return binding.root
    }

    private fun initRecyclerView(){
        //Recycler View
        binding.roomRecVw.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = roomAdapter
        }
    }

    private fun observeData(){
        virginViewModel.rooms.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                    //Load Spinner
                }

                is UIState.SUCCESS -> {
                    // Update adapter
//                    binding.jokesRecVw.visibility = View.VISIBLE

                    roomAdapter.setRooms(state.response)
                }

                is UIState.ERROR -> {
                    // Show error dialog

                    showError(state.error.localizedMessage){
                        virginViewModel.getRooms()
                    }
                }

                else -> {}
            }


        }

        virginViewModel.getRooms()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let{
            null
        }
    }
}