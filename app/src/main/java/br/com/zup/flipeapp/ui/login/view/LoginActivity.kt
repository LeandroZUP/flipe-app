package br.com.zup.flipeapp.ui.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.flipeapp.data.model.User
import br.com.zup.flipeapp.databinding.ActivityLoginBinding
import br.com.zup.flipeapp.ui.home.view.HomeActivity
import br.com.zup.flipeapp.ui.login.viewmodel.LoginViewModel
import br.com.zup.flipeapp.ui.register.view.RegisterActivity
import br.com.zup.flipeapp.utilities.LOGIN_ERROR_MESSAGE
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        clickOnTextRegister()
        clickOnEnterButton()
    }

    private fun clickOnTextRegister() {
        binding.tvNewUser.setOnClickListener {
            goToRegister()
        }
    }

    private fun clickOnEnterButton() {
        binding.btnLogin.setOnClickListener {
            val user = getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun getDataUser(): User {
        return User(
            email = binding.etEmail.text.toString().lowercase(),
            password = binding.etPassword.text.toString().lowercase()
        )
    }

    private fun goToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
        this.finish()
    }

    private fun initObservers() {
        viewModel.loginState.observe(this) {
            if (it) {
                goToHome()
            } else {
                Snackbar.make(binding.root, LOGIN_ERROR_MESSAGE, Snackbar.LENGTH_LONG).show()
            }
        }

        viewModel.errorState.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}