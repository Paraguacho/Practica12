package mx.edu.itson.practica12


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout:  Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        val email = intent.extras?.getString("User")

        tvUserEmail=findViewById(R.id.tvUserEmail)
        btnLogout=findViewById(R.id.btnLogout)
        tvUserEmail.text = email

        btnLogout.setOnClickListener{
            auth.signOut()
            val intent = Intent (this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}