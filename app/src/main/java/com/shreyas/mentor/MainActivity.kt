package com.shreyas.mentor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lateinit var logo: ImageView
        lateinit var title: TextView
        lateinit var usn: EditText
        lateinit var login: Button

        logo=findViewById(R.id.logo)
        title=findViewById(R.id.title)
        usn=findViewById(R.id.usn)
        login=findViewById(R.id.submit)

        login.setOnClickListener {

            var USN=usn.text.toString()
            try {
                if(USN.equals(""))
                {
                    throw Exception("USN NOT ENTERED ")
                    Toast.makeText(this, "ENTER USN ", Toast.LENGTH_SHORT).show()
                }
                else{
                    var nextpage=Intent(this,secact::class.java)
                    nextpage.putExtra("USNNO",USN)
                    startActivity(nextpage)
                    Toast.makeText(this, "LOGED IN AS $USN", Toast.LENGTH_SHORT).show()
                }
            }
            catch (e:Exception)
            {
                println(e)
                Toast.makeText(this, "ENTER USN ", Toast.LENGTH_SHORT).show()
            }


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}