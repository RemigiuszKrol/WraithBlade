package com.example.courseapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onResume() {
        super.onResume()

        // Wypisane zawartości extras jesli jest przekazana
        if(intent.hasExtra("login")) textView.setText("Login:  "+intent.getCharSequenceExtra("login"))
        if(intent.hasExtra("password")) textView2.setText("Hasło:  "+intent.getCharSequenceExtra("password"))
        if(intent.hasExtra("email")) textView3.setText("E-mail:  "+intent.getCharSequenceExtra("email"))
        if(intent.hasExtra("plec")) textView4.setText("Płeć:  "+intent.getCharSequenceExtra("plec"))
        if(intent.hasExtra("newsLetter")) textView5.setText("NewsLetter:  "+intent.getCharSequenceExtra("newsLetter"))
    }
}