package br.com.zup.flipeapp.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import br.com.zup.flipeapp.domain.repository.AuthenticationRepository

class HomeViewModel: ViewModel() {
    private val authenticationRepository = AuthenticationRepository()

    fun getDisplayName() = authenticationRepository.getDisplayName()

    fun logout() = authenticationRepository.logout()

}
