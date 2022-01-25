package edu.uw.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceCharge = findViewById<EditText>(R.id.editTxtServiceCharge)
        var tip = findViewById<Button>(R.id.btnTip)

    }

    //As a user, when I enter data into the service charge textedit, it should read like a USD currency amount ("$15.23"); two decimal places, and prefixed by "$".
    //
    //As a user, when I enter data into the service charge textedit, it should enable the "Tip" pushbutton.
    //
    //As a user, when I push the "Tip" pushbutton, it should calculate the tip (15% of the value in the service charge textedit) and display that value in a Toast message. The value displayed should be displayed as USD currency ("$15.23"): two decimal places, prefixed by "$".
    //
}