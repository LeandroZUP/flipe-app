package br.com.zup.flipeapp.ui.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.flipeapp.data.datasource.remote.RetrofitService
import br.com.zup.flipeapp.data.model.modelo.ModeloResponse
import br.com.zup.flipeapp.domain.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val authenticationRepository = AuthenticationRepository()
    val stateModeloResponse = MutableLiveData<ModeloResponse>()

    fun getDisplayName() = authenticationRepository.getDisplayName()

    fun getUserEmail() = authenticationRepository.getEmailUser()

    fun logoutUser() = authenticationRepository.logoutUser()

    fun getAllNetwork(){
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO){
                Log.d("SUCESSO", "Não chegou aqui vm")
                RetrofitService.apiService.getModelos(59)
            }
        stateModeloResponse.value = response


        }
    }

}