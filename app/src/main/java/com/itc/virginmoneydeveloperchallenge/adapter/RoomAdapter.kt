package com.itc.virginmoneydeveloperchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itc.virginmoneydeveloperchallenge.databinding.RoomRowViewBinding
import com.itc.virginmoneydeveloperchallenge.model.rooms.RoomsResponseItem

class RoomAdapter(
    private val mRoomsList: MutableList<RoomsResponseItem> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder>(
) {

    fun setRooms(rooms: MutableList<RoomsResponseItem>) {
        mRoomsList.clear()
        mRoomsList.addAll(rooms)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
        MyViewHolder(
            RoomRowViewBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mRoomsList[position])

    override fun getItemCount(): Int  = mRoomsList.size

}

class MyViewHolder (
    private val binding: RoomRowViewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(room: RoomsResponseItem)
    {
        binding.roomIdTxtVw.text = room.id
        if(room.isOccupied == true){
            binding.roomOccupiedTxtVw.text = "Occupied"
        } else binding.roomOccupiedTxtVw.text = "Open"
        binding.roomMaxTxtVw.text = room.maxOccupancy.toString()
        binding.roomCreatedTxtVw.text = room.createdAt
    }

}