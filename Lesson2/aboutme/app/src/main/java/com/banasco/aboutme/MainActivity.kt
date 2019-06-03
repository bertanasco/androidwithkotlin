package com.banasco.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editNickNameText: EditText
    lateinit var nickNameText: TextView
    lateinit var editButton: Button
    lateinit var doneButton: Button

    lateinit var imm: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doneButton = findViewById(R.id.done)
        editButton = findViewById(R.id.edit)
        editNickNameText = findViewById(R.id.nickname)
        nickNameText = findViewById(R.id.nicknametext)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        doneButton.setOnClickListener {
            addNickName(it) }

        editButton.setOnClickListener {
            editNickName(it)
        }
    }

    private fun addNickName(view: View) {
        nickNameText.text = editNickNameText.text
        nickNameText.visibility = View.VISIBLE
        editButton.visibility = View.VISIBLE
        editNickNameText.visibility = View.GONE
        view.visibility = View.GONE

        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun editNickName(view: View) {
        editNickNameText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        nickNameText.visibility = View.GONE
        view.visibility = View.GONE

    }
}
