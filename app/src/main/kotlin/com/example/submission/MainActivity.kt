package com.example.submission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.submission.core.data.Resource
import com.example.submission.core.ui.MovieAdapter
import com.example.submission.core.ui.ViewModelFactory
import com.example.submission.databinding.ActivityMainBinding
import com.example.submission.detail.DetailMovieActivity
import com.example.submission.favorite.FavoriteActivity
import com.example.submission.home.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        val factory = ViewModelFactory.getInstance(this)
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeViewModel.movie.observe(this) { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        movieAdapter.setData(movie.data)
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        binding.viewError.root.visibility = View.VISIBLE
                        binding.viewError.tvError.text =
                            movie.Message ?: getString(R.string.something_wrong)
                    }
                }
            }
        }

        with(binding.rvMovie) {
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                Intent(this, FavoriteActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}