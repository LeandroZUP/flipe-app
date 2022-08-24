package br.com.zup.flipeapp.ui.splash.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.flipeapp.R
import br.com.zup.flipeapp.ui.home.view.HomeActivity
import br.com.zup.flipeapp.ui.login.view.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val user: FirebaseAuth = Firebase.auth
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        timer.schedule(object: TimerTask() {
            override fun run() {
                jump()
            }
        }, 3000)
    }

    private fun jump() {
        timer.cancel()
        if (user.currentUser == null) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        this.finish()
    }
}