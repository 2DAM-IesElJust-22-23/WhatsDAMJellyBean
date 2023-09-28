package com.ieseljust.pmdm.whatsdamjellybean

import android.content.Intent
import android.net.InetAddresses.isNumericAddress
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ieseljust.pmdm.whatsdamjellybean.databinding.ActivityMainBinding
import com.ieseljust.pmdm.whatsdamjellybean.databinding.ActivityMessagesWindowBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: ActivityMessagesWindowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.buttonConnect.setOnClickListener {
            val intent = Intent(baseContext, MessagesWindow::class.java)
            var nick = binding.nickNameText.text.toString()
            var ipOk = binding.serverAddressText.text.toString()
            if (nick != "") {
                intent.putExtra("nick", nick)
                if (isNumericAddress(ipOk)) {
                    intent.putExtra("ipOk", ipOk)
                    startActivity(intent)
                }
            }
        }
    }
}