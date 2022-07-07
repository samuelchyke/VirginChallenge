package com.itc.virginmoneydeveloperchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itc.virginmoneydeveloperchallenge.R
import com.itc.virginmoneydeveloperchallenge.databinding.PeopleRowViewBinding
import com.itc.virginmoneydeveloperchallenge.databinding.RoomRowViewBinding
import com.itc.virginmoneydeveloperchallenge.model.people.PeopleResponseItem
import com.squareup.picasso.Picasso

class PeopleAdapter(
    private val mPeopleList: MutableList<PeopleResponseItem> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder2>(
) {

    fun setPeople(people: MutableList<PeopleResponseItem>) {
        mPeopleList.clear()
        mPeopleList.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder2 =
        MyViewHolder2(
            PeopleRowViewBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) =
        holder.bind(mPeopleList[position])

    override fun getItemCount(): Int  = mPeopleList.size

}

class MyViewHolder2 (
    private val binding: PeopleRowViewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(people: PeopleResponseItem)
    {
        binding.peopleJobTxtVw.text = people.jobTitle
        binding.peopleFirstNameTxtVw.text = people.firstName
        binding.peopleLastNameTxtVw.text = people.lastName
        binding.peopleEmailTxtVw.text = people.email
        Picasso.get()
            .load(people.avatar)
            .placeholder(R.drawable.ic_dashboard_black_24dp)
            .fit()
            .into(binding.peopleAvatarImgVw)
    }

}

