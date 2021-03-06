package com.example.courseapi

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*


fun checkUserPassword(password: EditText, warmPassword: TextView){
    // Alternatywne podejście walidacji jako nasłuchiwanie zmian
    password.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(password.length() == 0)  warmPassword.visibility = TextView.INVISIBLE
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(password.length() < 8){
                warmPassword.setText("Hasło za krótkie.")
                warmPassword.visibility = TextView.VISIBLE
                warmPassword.setTextColor(Color.RED)
            }
            else{
                warmPassword.setText("Poprawne hasło")
                warmPassword.visibility = TextView.VISIBLE
                warmPassword.setTextColor(Color.GREEN)
            }
        }
    })
}

fun checkUserEmail(email: EditText, warmEmail: TextView){
    email.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            if(email.length() == 0)  warmEmail.visibility = TextView.INVISIBLE
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            warmEmail.setText("Niepoprawny email")
            warmEmail.setTextColor(Color.RED)
            for(i in email.text) {
                if(i == '@'){
                    warmEmail.setText("Email poprawny")
                    warmEmail.visibility = TextView.VISIBLE
                    warmEmail.setTextColor(Color.GREEN)
                }
                warmEmail.visibility = TextView.VISIBLE
            }
        }
    })
}


/*
// Funkcja działająca z każdą aktywnością użytkownika - walidacja danych wejściowych
override fun onUserInteraction() {
    super.onUserInteraction()

    if(tPassword.isFocused){
        if(tPassword.length() < 8){
            tvPasswordInfo.setText("Haslo powinno zawierać minimum 8 znaków.")
            tvPasswordInfo.visibility = TextView.VISIBLE
            tvPasswordInfo.setTextColor(Color.RED)
        }
        else{
            tvPasswordInfo.setText("Podane hasło jest poprawne.")
            tvPasswordInfo.visibility = TextView.VISIBLE
            tvPasswordInfo.setTextColor(Color.GREEN)
        }
    }
    else{
        tvPasswordInfo.visibility = TextView.INVISIBLE
        tvPasswordInfo.setTextColor(Color.BLACK)
    }

    if(tEmail.isFocused){
        tvEmailInfo.setText("Niepoprawny email")
        tvEmailInfo.setTextColor(Color.RED)
        for(i in tEmail.text) {
            if(i == '@'){
                tvEmailInfo.setText("Podany email jest poprawny")
                tvEmailInfo.visibility = TextView.VISIBLE
                tvEmailInfo.setTextColor(Color.GREEN)
            }
            else{
                tvEmailInfo.visibility = TextView.VISIBLE
            }
        }
    }
    else{
        tvEmailInfo.visibility = TextView.INVISIBLE
        tvEmailInfo.setTextColor(Color.BLACK)
    }
}

*/