package com.shreyas.mentor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class secact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secact)
        lateinit var headerimg: ImageView

        lateinit var logout: Button
        lateinit var greets: TextView
        lateinit var form: TextView
        lateinit var clickme: Button

        headerimg=findViewById(R.id.imageView)

        logout=findViewById(R.id.button)
        greets=findViewById(R.id.textView)
        form=findViewById(R.id.textView2)
        clickme=findViewById(R.id.clickme)
        var usn:String=reciever()
        greets.text="WELCOME ${usn.uppercase()}"

        logout.setOnClickListener {
            var transition=Intent(this,MainActivity::class.java)
            startActivity(transition)
            Toast.makeText(this, "LOGED OUT ", Toast.LENGTH_LONG).show()
        }
        clickme.setOnClickListener {
            var transition=Intent(this,thirdpg::class.java)
            startActivity(transition)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun reciever():String
    {
        var data:Bundle?=intent.extras
        var data1=data?.getString("USNNO").toString()
        return data1.toString()

    }
}