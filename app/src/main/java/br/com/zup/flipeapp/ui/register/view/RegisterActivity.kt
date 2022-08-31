package br.com.zup.flipeapp.ui.register.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.flipeapp.data.model.user.User
import br.com.zup.flipeapp.databinding.ActivityRegisterBinding
import br.com.zup.flipeapp.ui.home.view.HomeActivity
import br.com.zup.flipeapp.ui.login.view.LoginActivity
import br.com.zup.flipeapp.ui.register.viewmodel.RegisterViewModel
import br.com.zup.flipeapp.utilities.USER_KEY
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        clickOnSaveButton()
        clickOnTextLogin()
    }

    private fun clickOnTextLogin() {
        binding.tvBackToLogin.setOnClickListener {
            goToLogin()
        }
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        this.finish()
    }

    private fun clickOnSaveButton() {
        binding.btnRegister.setOnClickListener {
            val user = getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun getDataUser(): User {
        return User(
            name = binding.etDisplayName.text.toString().lowercase(),
            email = binding.etEmail.text.toString().lowercase(),
            password = binding.etPassword.text.toString()
        )
    }

    private fun initObservers() {
        viewModel.registerState.observe(this) {
            goToHome(it)
        }

        viewModel.errorState.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun goToHome(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
        this.finish()
    }
}