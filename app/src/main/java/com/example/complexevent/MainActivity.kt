package com.example.complexevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var clarification: CheckBox
    private lateinit var saveButton: Button
    private lateinit var viewText: TextView
    private lateinit var progressCheck: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.editTextText)
        saveButton = findViewById(R.id.button)
        viewText = findViewById(R.id.textView)
        progressCheck = findViewById(R.id.progressBar)
        clarification = findViewById(R.id.checkBox)
        progressCheck.setProgress(0)
        saveButton.setOnClickListener {
            if (clarification.isChecked) {
                var str: String = inputText.text.toString()
                if (str.contains("[A-Za-z0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
                    progressCheck.incrementProgressBy(10)
                    viewText.text = str
                } else {
                    val Error = Toast.makeText(this, "Пустое поле для ввода", Toast.LENGTH_LONG)
                    Error.show()
                }

            } else {
                val myToast = Toast.makeText(this, "Вы не нажали на флажок", Toast.LENGTH_LONG)
                myToast.show()
            }
        }

    }
}