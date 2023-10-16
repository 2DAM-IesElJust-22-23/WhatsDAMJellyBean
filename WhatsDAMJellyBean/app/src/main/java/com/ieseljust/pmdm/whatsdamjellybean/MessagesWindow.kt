package com.ieseljust.pmdm.whatsdamjellybean

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.ieseljust.pmdm.whatsdamjellybean.databinding.ActivityMessagesWindowBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MessagesWindow : AppCompatActivity() {

    private lateinit var binding: ActivityMessagesWindowBinding
    data class Mensaje(val usuario: String, val mensaje: String, val hora: String)
    private val mensajesEnviados = mutableListOf<Mensaje>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la vista utilizando el enlace generado por ViewBinding.
        binding = ActivityMessagesWindowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtiene referencias a las vistas de la interfaz de usuario
        val messageText = binding.MessageText
        val textView = binding.connectionInfoTextView
        val sendMessage = binding.sendMessage

        // Configurar el RecyclerView
        val recyclerView = binding.MensajesRecyclerView

        // Asociar el LayoutManager al RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Crear e inicializar tu adaptador (MyAdapter) y asignarlo al RecyclerView
        val adapter = MyAdapter(mensajesEnviados)
        recyclerView.adapter = adapter

        // Indicamos que el tamaño sea fijo
        recyclerView.setHasFixedSize(true)

        // Creamos una instancia de adaptador
        recyclerView.adapter = MyAdapter(mensajesEnviados)

        // Obtiene los valores de "NICKNAME_KEY" e "IPSERVER" del Intent
        val nickname = intent.getStringExtra("NICKNAME_KEY")
        val ipserver = intent.getStringExtra("IPSERVER")

        // Actualiza el texto de la información de conexión
        textView.text = "Conectat a $ipserver com a $nickname"

        // Configura el clic del botón "Send Message"
        // Limpia el texto del campo de mensaje
        sendMessage.setOnClickListener {
            val horaActual = LocalTime.now()
            val formatter = DateTimeFormatter.ofPattern("HH:mm")
            val hora = horaActual.format(formatter)

            mensajesEnviados.add(Mensaje(nickname.toString(),messageText.text.toString(),hora))

            messageText.text.clear()
        }
    }
}
