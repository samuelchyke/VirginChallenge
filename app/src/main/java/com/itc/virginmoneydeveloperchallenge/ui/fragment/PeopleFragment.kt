package com.itc.virginmoneydeveloperchallenge.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itc.virginmoneydeveloperchallenge.adapter.PeopleAdapter
import com.itc.virginmoneydeveloperchallenge.databinding.FragmentPeopleBinding
import com.itc.virginmoneydeveloperchallenge.util.UIState

class PeopleFragment : BaseFragment() {

    private val binding by lazy{
        FragmentPeopleBinding.inflate(layoutInflater)
    }

    private val peopleAdapter by lazy{
        PeopleAdapter()
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
        binding.peopleRecVw.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = peopleAdapter
        }
    }

    private fun observeData(){
        virginViewModel.people.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                    //Load Spinner
                }

                is UIState.SUCCESS2 -> {
                    // Update adapter
                    peopleAdapter.setPeople(state.response)
                }

                is UIState.ERROR -> {
                    // Show error dialog
                    showError(state.error.localizedMessage){
                        virginViewModel.getPeople()
                    }
                }

                else -> {}
            }


        }

        virginViewModel.getPeople()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding.let{
            null
        }
    }
}