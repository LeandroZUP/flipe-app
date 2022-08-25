package br.com.zup.flipeapp.ui.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import br.com.zup.flipeapp.R
import br.com.zup.flipeapp.databinding.ActivityHomeBinding
import br.com.zup.flipeapp.ui.home.viewmodel.HomeViewModel
import br.com.zup.flipeapp.ui.login.view.LoginActivity
import br.com.zup.flipeapp.utilities.HELLO

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar()
        }

    private fun supportActionBar() {
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = HELLO + viewModel.getDisplayName()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            //TODO Implement thunder_search layout
//            R.id.thunder_search -> {
//                goToSearch()
//                true
//            }
            //TODO Implement bookmark layout
//            R.id.bookmark -> {
//                goToBookmark()
//                true
//            }
            R.id.exit -> {
                viewModel.logoutUser()
                goToLogin()
                this.finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }


}