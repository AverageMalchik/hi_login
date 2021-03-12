package com.example.hi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var visibal = false

    //password and eye image toggle here
    private fun showpassword(visibal_copy: Boolean) {
        if (visibal_copy) {
            et_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            iv_eye.setImageResource(R.drawable.eye2_light)
        } else {
            et_password.transformationMethod = PasswordTransformationMethod.getInstance()
            iv_eye.setImageResource(R.drawable.eye1_light)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var obj4:View=findViewById(R.id.mainlayout)
        obj4.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN

        et_password.transformationMethod = PasswordTransformationMethod.getInstance()
        //clicking on the image view
        iv_eye.setOnClickListener {
            visibal = !visibal
            showpassword(visibal)
        }
        //checking username and password
        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            var error_msg: TextView = findViewById(R.id.tv_error)
            var redtint: EditText=findViewById(R.id.et_username)
            var redtint2: EditText=findViewById(R.id.et_password)
            if (username.isEmpty()) {
                et_username.setBackgroundResource(R.drawable.etuperror_light)
                et_username.setAlpha(0.5F)
                redtint.setTextColor(Color.WHITE)
                redtint.hint="Username                       REQUIRED"

            } else if (password.isEmpty()) {
                et_password.setBackgroundResource(R.drawable.etuperror_light)
                et_password.setAlpha(0.5F)
                redtint2.setTextColor(Color.WHITE)
                redtint2.hint="Password             REQUIRED"
            } else if (username == "jibran" && password == "iluvpaige") {
                val intent: Intent = Intent(this@MainActivity, Steak::class.java)
                startActivity(intent)
            } else {
                error_msg.text = "Incorrect Username or Password"
            }
        }

    }


}