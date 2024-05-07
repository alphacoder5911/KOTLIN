package com.shreyas.mentor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import java.util.jar.Attributes.Name

class thirdpg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thirdpg)
        lateinit var header:TextView
        lateinit var Name:EditText
        lateinit var Year:EditText
        lateinit var Gender: RadioGroup
//        lateinit var Male : RadioButton
//        lateinit var Female:RadioButton
        lateinit var Mobile:EditText
        lateinit var Submit:Button
        lateinit var gendar:String
        lateinit var emai:EditText

        Name=findViewById(R.id.name)
        Year=findViewById(R.id.year)
        Gender=findViewById(R.id.GENDER)
//        Male=findViewById(R.id.male)
    //    Female=findViewById(R.id.female)
        Mobile=findViewById(R.id.editText)
        Submit=findViewById(R.id.SUBMIT)
        emai=findViewById(R.id.ema)

        Gender.setOnCheckedChangeListener { group, checkedId ->

            if(checkedId==R.id.male)
            {
                gendar="MALE"
                Toast.makeText(this, "MALE", Toast.LENGTH_SHORT).show()
            }
            else if(checkedId==R.id.female)
            {
                gendar="FEMALE"
            }
        }
        Submit.setOnClickListener {

            var Naame=Name.text.toString()
            var yeaar=Year.text.toString()
            var mobilee=Mobile.text.toString()
            var em=emai.text.toString()

            try {
                if(Naame.equals("")&&yeaar.equals("")&&mobilee.equals("")&&gendar.equals("")&&em.equals(""))
                {
                    throw Exception("FORM NOT FILLED COMPLETELY ")
                    Toast.makeText(this, "FILL THE FORM COMPLETELY AS INSTRUCTED ", Toast.LENGTH_LONG).show()
                }
                else{
                    var transiton=Intent(this,fourthpage::class.java)
                    transiton.putExtra("NAAM",Naame)
                    transiton.putExtra("year",yeaar)
                    transiton.putExtra("mobile",mobilee)
                    transiton.putExtra("genderr",gendar)
                    transiton.putExtra("mail",em)
                    startActivity(transiton)
                }
            }
            catch (e:Exception)
            {
                println(e)
                Toast.makeText(this, "FORM NOT FILLED PROPERLY ", Toast.LENGTH_SHORT).show()
            }


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}