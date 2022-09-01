package br.com.zup.flipeapp.ui.search.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.flipeapp.R
import br.com.zup.flipeapp.domain.repository.AuthenticationRepository
import br.com.zup.flipeapp.ui.home.view.HomeActivity

class SearchActivity : AppCompatActivity() {
    private lateinit var homeActivity: HomeActivity
    private lateinit var authenticationRepository: AuthenticationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.thunder_search -> {
                //TODO viewSearch
                true
            }
            R.id.bookmark -> {
                homeActivity.goToBookmark()
                true
            }
            R.id.exit -> {
                authenticationRepository.logout()
                homeActivity.goToLogin()
                this.finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}