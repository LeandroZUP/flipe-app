package br.com.zup.flipeapp.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.flipeapp.data.model.user.User
import br.com.zup.flipeapp.domain.repository.AuthenticationRepository
import br.com.zup.flipeapp.utilities.EMAIL_ERROR_MESSAGE
import br.com.zup.flipeapp.utilities.LOGIN_ERROR_MESSAGE
import br.com.zup.flipeapp.utilities.PASSWORD_ERROR_MESSAGE

class LoginViewModel : ViewModel() {
    private val authenticationRepository = AuthenticationRepository()

    private var _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState

    private var _errorState = MutableLiveData<String>()
    val errorState: LiveData<String> = _errorState

    fun validateDataUser(user: User): Boolean {
        return when {
            validateEmailField(user) -> {
                false
            }
            validatePasswordField(user) -> {
                false
            }
            else -> {
                loginUser(user)
                true
            }
        }
    }

    private fun validateEmailField(user: User): Boolean {
        if (user.email.isEmpty()) {
            _errorState.value = EMAIL_ERROR_MESSAGE
            return true
        }
        return false
    }

    private fun validatePasswordField(user: User): Boolean {
        if (user.password.isEmpty()) {
            _errorState.value = PASSWORD_ERROR_MESSAGE
            return true
        }
        return false
    }

    private fun loginUser(user: User) {
        try {
            authenticationRepository.loginUser(
                user.email,
                user.password
            ).addOnSuccessListener {
                _loginState.value = true
            }.addOnFailureListener {
                _errorState.value = LOGIN_ERROR_MESSAGE
            }
        } catch (ex: Exception) {
            _errorState.value = ex.message
        }
    }
}