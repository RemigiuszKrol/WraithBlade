package com.example.courseapi

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// Aktywność główna do wersji Empty Activity
class MainActivity : AppCompatActivity() {

    // Utworzenie tagu do obserowowania w Logcat
    val TAG: String = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Wyświetlanie którkiego komunikatu po kliknięciu w przycisk
        bLeft.setOnClickListener{
            var bLeftMessage = Toast.makeText(applicationContext, "Witaj!", Toast.LENGTH_SHORT)
            bLeftMessage.show()

            // Utworzenie aktywnosci do intencji innej aktywności (mimo że Kotlin to odwołanie do klasy java
            var nowActivity: Intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(nowActivity)
        }

        // Wyświetlanie długiego komunkatu po wejsciu w przycisk
        bRight.setOnClickListener{
            var bRightMessage = Toast.makeText(applicationContext, "Test tekst!", Toast.LENGTH_LONG)
            bRightMessage.show()

            // Przejscie do linku, odpowiedź na zdarzenie kliknięcia jako nowa intencja - view address URL
            var addressYouTube = "https://www.youtube.com/watch?v=G12I7LfMw-Q"
            var channelRevolShen = Intent(ACTION_VIEW, Uri.parse(addressYouTube))
            startActivity(channelRevolShen)
        }
        // Zalogowanie informacji do Logcat - literka d - debug
        Log.d(TAG, "Metoda onCreate MainActivity")
    }

    // Wylistowane przeciążenia metod celem przedstawienia cyklu zycia aplikacji
    // onCreate -> onStart -> onResume -> <ACTIVITY> -> onPause -> onStop -> onDestroy
    // onPause -> <ACTIVITY> -> onResume
    // onPasue -> <Kill App> -> onCreate
    // onStop -> <Change Activity> -> onRestart -> onStart
    // onStop -> <Kill App> -> onCreate
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Metoda onStart MainActivity")
    }

    override fun onResume() {
        super.onResume()

        // pobranie wartości z Extras za pomoca klucza z SecondActivity
        if(intent.hasExtra("plec")) tIdPlec.setText(intent.getCharSequenceExtra("plec"))

        Log.d(TAG, "Metoda onResume MainActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Metoda onPause MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Metoda onStop MainActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Metoda onRestart MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Metoda onDestroy MainActivity")
    }
}

