package com.geeks.contacts

import android.provider.ContactsContract.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geeks.contacts.databinding.ItemViewBinding

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    val contactsList = ArrayList<Contacts>()

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemViewBinding.bind(item)
        fun bind(contacts: Contacts) = with(binding) {
            img.setImageResource(contacts.imageId)
            tvName.text = contacts.name
            tvEmail.text = contacts.email
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactsList[position])
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun addContact(contacts: com.geeks.contacts.Contacts){
        contactsList.add(contacts)
        notifyDataSetChanged()
    }
}