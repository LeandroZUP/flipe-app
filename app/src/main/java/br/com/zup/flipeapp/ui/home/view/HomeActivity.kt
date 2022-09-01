package br.com.zup.flipeapp.ui.home.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.zup.flipeapp.R
import br.com.zup.flipeapp.databinding.ActivityHomeBinding
import br.com.zup.flipeapp.ui.search.view.SearchActivity
import br.com.zup.flipeapp.ui.bookmark.view.BookmarkActivity
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
        //TODO Broken function. Arrange.
        //clickOnButtonSearch()
        spinners()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.bookmark -> {
                goToBookmark()
                true
            }
            R.id.thunder_search -> {
            // TODO viewSearch
                true
            }
            R.id.exit -> {
                viewModel.logout()
                goToLogin()
                this.finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun supportActionBar() {
        supportActionBar?.title = HELLO + viewModel.getDisplayName()
    }

    private fun clickOnButtonSearch() {
        binding.btnSearch.setOnClickListener {
            goToSearch()
        }
    }

    internal fun goToBookmark() {
        startActivity(Intent(this, BookmarkActivity::class.java))
    }

    internal fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun goToSearch() {
        startActivity(Intent(this, SearchActivity::class.java))
    }

    private fun spinners(){
        spinnerCarManufacturer()
        spinnerCarModel()
        spinnerModelYear()
    }

    private fun spinnerCarManufacturer(){
        val spinnerCarManufacturer: Spinner = findViewById(R.id.sp_car_manufacturers)
        //TODO Change ArrayAdapter to CursorAdapter
        ArrayAdapter.createFromResource(this, R.array.spinner_car_manufacturer,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCarManufacturer.adapter = adapter
        }
        //TODO Implement callback method OnItemSelectedListener, with onItemSelected() and onNothingSelected().
        //TODO Implement setOnItemSelectedListener()
    }

    private fun spinnerCarModel(){
        val spinnerCarModel: Spinner = findViewById(R.id.sp_car_model)
        //TODO Change ArrayAdapter to CursorAdapter
        ArrayAdapter.createFromResource(this, R.array.spinner_car_model,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCarModel.adapter = adapter
        }
        //TODO Implement callback method OnItemSelectedListener, with onItemSelected() and onNothingSelected().
        //TODO Implement setOnItemSelectedListener()
    }

    private fun spinnerModelYear(){
        val spinnerModelYear: Spinner = findViewById(R.id.sp_model_year)
        //TODO Change ArrayAdapter to CursorAdapter
        ArrayAdapter.createFromResource(this, R.array.spinner_model_year,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerModelYear.adapter = adapter
        }
        //TODO Implement callback method OnItemSelectedListener, with onItemSelected() and onNothingSelected().
        //TODO Implement setOnItemSelectedListener()
    }

}
