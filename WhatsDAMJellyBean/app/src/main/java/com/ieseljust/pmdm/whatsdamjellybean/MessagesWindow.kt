package com.ieseljust.pmdm.whatsdamjellybean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieseljust.pmdm.whatsdamjellybean.databinding.ActivityMessagesWindowBinding

class MessagesWindow : AppCompatActivity() {


    private lateinit var binding: ActivityMessagesWindowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMessagesWindowBinding.inflate(layoutInflater)
        val view2=binding.root
        setContentView(view2)

        val message = intent.getStringExtra("nick")
        val ipVal = intent.getStringExtra("ipOk")
        binding.connectionInfoTextView.text = "Connectat a "+ipVal+" com a "+ message

    }
}