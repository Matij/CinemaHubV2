package com.fonteraro.martaco.cinemahub.ui.main

import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity
import com.fonteraro.martaco.cinemahub.ui.main.adapter.MoviesAdapter
import android.os.Bundle
import com.fonteraro.martaco.cinemahub.R
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.fonteraro.martaco.cinemahub.BR
import com.fonteraro.martaco.cinemahub.databinding.ActivityMainBinding
import com.fonteraro.martaco.cinemahub.ui.details.DetailsActivity
import com.fonteraro.martaco.cinemahub.utils.AppConstants
import com.fonteraro.martaco.cinemahub.utils.EventObserver
import javax.inject.Inject

private const val GRID_SPAN = 4

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    SearchView.OnQueryTextListener {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private var moviesAdapter: MoviesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseContentView()
        updateUI()
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        val viewModel: MainViewModel by viewModels { viewModelFactory }
        return viewModel
    }

    private fun initialiseContentView() {
        val moviesRecyclerView = viewDataBinding.recyclerView
        moviesRecyclerView.layoutManager = GridLayoutManager(this, GRID_SPAN)
        moviesAdapter = MoviesAdapter(::onMovieClicked)
        moviesRecyclerView.adapter = moviesAdapter
    }

    private fun updateUI() {
        with(viewModel) {
            movies.observe(this@MainActivity, EventObserver { movieList ->
                moviesAdapter!!.submitList(movieList)
            })
            isLoading.observe(this@MainActivity, EventObserver { isLoading ->
                viewDataBinding!!.progressBar.isVisible = isLoading
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return true
    }

    // SearchView callbacks
    override fun onQueryTextChange(query: String): Boolean {
        viewModel.onMovieQuery(query)
        return true
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    private fun onMovieClicked(id: Long) {
        Intent(this, DetailsActivity::class.java)
            .apply { putExtra(AppConstants.EXTRA_KEY_MOVIE_ID, id) }
            .also { startActivity(it) }
    }
}
