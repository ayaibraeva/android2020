package com.example.lab4_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.mail_fragment.*

class MailFragment(): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mail_fragment, container, false)
    }

    private var messageAdapter: com.example.lab4_2.Adapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messages: MutableList<Message> = mutableListOf()
        messages.add(Message("Title 1", "Ayaulym", "textTexttextText"))
        messages.add(Message("Title 2", "Zarina", "fdfs"))
        messages.add(Message("Title 3", "Dayana", "fsdfs"))
        messages.add(Message("Title 4", "Diana", "vcxv"))
        messages.add(Message("Title 5", "Sender1", "hythht"))
        messages.add(Message("Title 6", "Sender2", "wedw"))
        messages.add(Message("Title 7", "Sender3", "mama"))
        messages.add(Message("Title 8", "Sender4", "dd[w"))
        messages.add(Message("Title 9", "Sender5", "textTex[f[[ttextText"))
        messageAdapter = Adapter(
            messageClickListener = {
                this.goToMailDetails(it)
            }
        )
        val manager = LinearLayoutManager(context)
        messageRecyclerView.apply {
            layoutManager = manager
            adapter = messageAdapter
        }
        messageAdapter?.addItems(messages)

    }

    private fun goToMailDetails(text: String) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.right, MailDetail.create(text))
            ?.apply { addToBackStack(this::class.java.simpleName) }
            ?.commit()
    }
}