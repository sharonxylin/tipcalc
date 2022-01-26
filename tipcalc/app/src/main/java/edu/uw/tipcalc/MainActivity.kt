package edu.uw.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.text.Editable
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serviceCharge = findViewById<EditText>(R.id.editTxtServiceCharge)
        val tip = findViewById<Button>(R.id.btnTip)
        val nonNum = Regex("[$,.]")
        var amount = ""
        serviceCharge.addTextChangedListener(
            object:TextWatcher{
                override fun afterTextChanged(s: Editable?){}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    serviceCharge.removeTextChangedListener(this)
                    val newAmount = NumberFormat.getCurrencyInstance(Locale.US).format((serviceCharge.text.toString().replace(nonNum, "").toDouble() / 100))
                    serviceCharge.setText(newAmount)
                    serviceCharge.setSelection(serviceCharge.length())
                    if(serviceCharge.text.toString().equals("$0.00")){
                        serviceCharge.setText("")
                        tip.isEnabled=false
                    }else{
                        tip.isEnabled=true
                    }
                    serviceCharge.addTextChangedListener(this)
                    amount = newAmount
                }
            }
        )

        tip.setOnClickListener({
            val tip = amount.replace(nonNum, "").toDouble() / 100 * 0.15
            val toastMessage = "Tip at 15%: $${"%.2f".format(tip)}"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        })
    }


    //As a user, when I enter data into the service charge textedit, it should read like a USD currency amount ("$15.23"); two decimal places, and prefixed by "$".
    //
    //As a user, when I enter data into the service charge textedit, it should enable the "Tip" pushbutton.
    //
    //
}