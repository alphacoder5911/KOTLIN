package com.shreyas.mentor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class fourthpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourthpage)
        lateinit var name:TextView
        lateinit var year:TextView
        lateinit var emil:TextView
        lateinit var gen:TextView
        lateinit var mobile:TextView
        lateinit var mentor:TextView



        name=findViewById(R.id.dispname)
        year=findViewById(R.id.year)
        gen=findViewById(R.id.gender)
        emil=findViewById(R.id.emai)
        mobile=findViewById(R.id.mob)
        mentor=findViewById(R.id.men)




        var ment=generMentor()

        var bundle:Bundle?=intent.extras
        var namee=bundle?.getString("NAAM").toString()
        var yearr=bundle?.getString("year").toString()
        var emaill=bundle?.getString("mail").toString()
        var gend=bundle?.getString("genderr").toString()
        var mo=bundle?.getString("mobile").toString()
        name.text="${namee.uppercase()}"
        year.text="$yearr"
       emil.text="$emaill"
        gen.text="$gend"
        mobile.text="$mo"
        mentor.text="$ment"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
        fun generMentor():String{
            var generate= listOf("ABC","DEF","GHI","JKL","MNO").random()
            return generate

        }

}