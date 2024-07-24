package com.geeks.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = ContactsAdapter()

    private val contactsNameMap = mapOf(
        R.drawable.img1 to "Mirbek Atabekov",
        R.drawable.img2 to "Gulnur Satylganova",
        R.drawable.img3 to "Abir Kasenov",
        R.drawable.img4 to "Begish",
        R.drawable.img5 to "Non Stop",
        R.drawable.img6 to "Guljigit Kalykov",
        R.drawable.img7 to " Nazira Aitbekova",
        R.drawable.img8 to "Anjelika",
        R.drawable.img9 to "Bayastan",
        R.drawable.img10 to "Zhijdesh",
        R.drawable.img11 to "Omar"
    )

    private val contactsEmailMap = mapOf(
        R.drawable.img1 to "Mirbek.Atabekov@gmail.com",
        R.drawable.img2 to "Gulnur3734@mail.com",
        R.drawable.img3 to "A.Kasenov@web.de",
        R.drawable.img4 to "Begish12@mail.ru",
        R.drawable.img5 to "NonStop.kg@gmail.com",
        R.drawable.img6 to "Gul.Kalykov@mail.com",
        R.drawable.img7 to " Nazira.123@gmail.com",
        R.drawable.img8 to "Anjelika@web.de",
        R.drawable.img10 to "Zhijdesh@mail.com",
        R.drawable.img11 to "Omar@gmail.com"
    )

    private val imageIdList = listOf(
       R.drawable.img1,
       R.drawable.img2,
       R.drawable.img3,
       R.drawable.img4,
       R.drawable.img5,
       R.drawable.img6,
       R.drawable.img7,
       R.drawable.img8,
       R.drawable.img9,
       R.drawable.img10,
       R.drawable.img11,
        )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun init() {
        binding.apply {
            rvName.layoutManager = LinearLayoutManager(this@MainActivity)
            rvName.adapter = adapter
            btnAdd.setOnClickListener {
                if (index >= imageIdList.size) index = 0
                val imageId = imageIdList[index]
                val contactName = contactsNameMap[imageId] ?: "Unknown"
                val contactEmail = contactsEmailMap[imageId] ?: "Unknown"
                val contact = Contacts(imageId, contactName, contactEmail)
                adapter.addContact(contact)
                index++
            }
        }
    }
}