package com.ieseljust.pmdm.whatsdamjellybean

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ieseljust.pmdm.whatsdamjellybean.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var nickname = ""
    private var ipserver = ""

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            nickname = savedInstanceState.getString("nickname", "")
            ipserver = savedInstanceState.getString("ipserver", "")
        }

        binding.buttonConnect.setOnClickListener {
            nickname = binding.nickNameText.text.toString()
            ipserver = binding.serverAddressText.text.toString()

            if (nickname.isNotEmpty() && isNumericIPAddress(ipserver)) {
                val intent = Intent(this, MessagesWindow::class.java)
                intent.putExtra("NICKNAME_KEY", nickname)
                intent.putExtra("IPSERVER", ipserver)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nickname", nickname)
        outState.putString("ipserver", ipserver)
    }

    private fun isNumericIPAddress(ip: String): Boolean {
        // Implement your IP address validation logic here.
        // You can use regular expressions or other methods to validate the format.
        // Return true for valid IP addresses and false for invalid ones.
        // Example using a simple regular expression:
        val ipPattern = """\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}"""
        return ip.matches(ipPattern.toRegex())
    }

}