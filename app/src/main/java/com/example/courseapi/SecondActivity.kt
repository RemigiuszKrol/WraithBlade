package com.example.courseapi

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        checkUserEmail(tEmail, tvEmailInfo) //Walidacja email
        checkUserPassword(tPassword, tvPasswordInfo) // walidacja hasła

        /*
        // obsługa pola RadioGroup
        rgSexGroup.setOnCheckedChangeListener {group, checkedId -> // Nasluchiwanie kliknięcia wyboru -> akcja
            run {
                val intentActivatedSexGroup: Intent = Intent(applicationContext, MainActivity::class.java) // Deklaracja intencji dla MainActivity
                var rbSexGroupId: RadioButton = findViewById(checkedId)                                    // Deklaracja funkcji pobierającej wybrany RB
                intentActivatedSexGroup.putExtra("plec", rbSexGroupId.text)                                // utworzenie extras z wyslanień do MainActivity
                startActivity(intentActivatedSexGroup)                                                     // Wywołanie intencji
            }
        }
        */
    }

    fun submitData(view: View){
        if(!cbRegulationsAcceptance.isChecked)
            Toast.makeText(applicationContext, "Prosze zaakceptować regulamin", Toast.LENGTH_SHORT).show()
        else{
            // dodanie Extras do intencji
            val intent = Intent(applicationContext, ProfileActivity::class.java)
            intent.putExtra("login", tLogin.text)
            intent.putExtra("password", tPassword.text)
            intent.putExtra("email", tEmail.text)
            intent.putExtra("plec", findViewById<RadioButton>(rgSexGroup.checkedRadioButtonId).text)

            // sprawdzenie czy zaznaczono CheckBox
            if(cbNewsLetterAcceptance.isChecked) intent.putExtra("newsLetter", "TAK")
            else intent.putExtra("newsLetter", "NIE")

            // Start intencji
            startActivity(intent)
        }
    }
}