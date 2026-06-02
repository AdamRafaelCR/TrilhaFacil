package com.example.trilhafacil
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val listaTrilhas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTitulo = findViewById<TextView>(R.id.textView)
        val editNomeTrilha = findViewById<EditText>(R.id.editTextText)
        val btnPlanejar = findViewById<Button>(R.id.button3)

        val switchNoturna = findViewById<Switch>(R.id.switch1)
        val btnTrilhasSalvas = findViewById<Button>(R.id.button)

        btnPlanejar.setOnClickListener {
            val nomeTrilha = editNomeTrilha.text.toString().trim()

            if (nomeTrilha.isEmpty()) {
                Toast.makeText(this, "Por favor, digite o nome de uma trilha!", Toast.LENGTH_SHORT).show()
            } else {
                val sufixoNoturno = if (switchNoturna.isChecked) " (Noturna)" else " (Diurna ️)"
                val trilhaFormatada = "$nomeTrilha$sufixoNoturno"

                listaTrilhas.add(trilhaFormatada)

                txtTitulo.text = "Próxima aventura:\n$trilhaFormatada!"

                Toast.makeText(this, "Trilha '$nomeTrilha' planejada com sucesso! ", Toast.LENGTH_LONG).show()

                editNomeTrilha.text.clear()
                switchNoturna.isChecked = false
            }
        }

        btnTrilhasSalvas.setOnClickListener {
            if (listaTrilhas.isEmpty()) {
                Toast.makeText(this, "Nenhuma trilha salva ainda! Comece a planejar. 🗺️", Toast.LENGTH_SHORT).show()
            } else {
                val todasAsTrilhas = listaTrilhas.joinToString(separator = "\n")

                Toast.makeText(this, "Trilhas Planejadas:\n$todasAsTrilhas", Toast.LENGTH_LONG).show()
            }
        }
    }
}