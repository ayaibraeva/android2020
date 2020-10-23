package com.example.lab4_2

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_fragment.view.*
class Adapter constructor(private val messageClickListener: (text:String) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messageList:MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContactViewHolder).bind(messageList[position], messageClickListener)

    }

    fun addItems(list: List<Message>){
        messageList.clear()
        messageList.addAll(list)
        notifyDataSetChanged()
    }

    private class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.items_fragment, parent, false)){

        private val senderTextView = itemView.senderTextView
        private val titleTextView = itemView.titleTextView
        private val messageTexView = itemView.messageTextView
        private val itemLayout = itemView.items_fragment_layout

        fun bind(message:Message, messageClickListener: (text: String) -> Unit){
            senderTextView.text = message.getSender()
            titleTextView.text = message.getTitle()
           messageTexView.text = message.getMessageText()
            itemLayout.setOnClickListener {
                messageClickListener(message.getMessageText())
            }
        }

    }
}