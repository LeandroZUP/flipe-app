package br.com.zup.flipeapp.domain

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationRepository {
    class AuthenticationRepository {
        private val auth: FirebaseAuth = Firebase.auth

        fun registerUser(email: String, password: String): Task<AuthResult> {
            return auth.createUserWithEmailAndPassword(email, password)
        }

        fun updateUserProfile(name: String): Task<Void>? {
            val profile = UserProfileChangeRequest.Builder().setDisplayName(name).build()
            return auth.currentUser?.updateProfile(profile)
        }

        fun loginUser(email: String, password: String): Task<AuthResult> {
            return auth.signInWithEmailAndPassword(email, password)
        }

        fun logoutUser() = auth.signOut()

        fun getNameUser(): String = auth.currentUser?.displayName.toString()

        fun getEmailUser(): String = auth.currentUser?.email.toString()
    }
}