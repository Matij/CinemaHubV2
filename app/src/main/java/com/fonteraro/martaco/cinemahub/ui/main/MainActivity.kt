package com.fonteraro.martaco.cinemahub.ui.main

import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity
import com.fonteraro.martaco.cinemahub.ui.main.callback.IMovieClickListener
import com.fonteraro.martaco.cinemahub.ui.main.adapter.sortedlist.SortedMoviesAdapter
import android.os.Bundle
import com.fonteraro.martaco.cinemahub.R
import androidx.recyclerview.widget.GridLayoutManager
import android.content.Intent
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import com.fonteraro.martaco.cinemahub.BR
import com.fonteraro.martaco.cinemahub.databinding.ActivityMainBinding
import com.fonteraro.martaco.cinemahub.ui.details.DetailsActivity
import com.fonteraro.martaco.cinemahub.utils.AppConstants
import com.fonteraro.martaco.cinemahub.utils.EventObserver
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding?, MainViewModel?>(),
    SearchView.OnQueryTextListener, IMovieClickListener {

    @Inject lateinit var mainViewModel: MainViewModel
    private var moviesAdapter: SortedMoviesAdapter? = null

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
        return mainViewModel
    }

    private fun initialiseContentView() {
        val moviesRecyclerView = viewDataBinding!!.recyclerView
        moviesRecyclerView.layoutManager = GridLayoutManager(this, 4)
        moviesAdapter = SortedMoviesAdapter(this, this)
        moviesRecyclerView.adapter = moviesAdapter
    }

    private fun updateUI() {
        with(mainViewModel) {
            movies.observe(this@MainActivity, EventObserver { movieList ->
                moviesAdapter!!.edit()
                    .replaceAll(movieList)
                    .commit()
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

    override fun onMovieClicked(id: Long) {
        Intent(this, DetailsActivity::class.java)
            .apply { putExtra(AppConstants.EXTRA_KEY_MOVIE_ID, id) }
            .also { startActivity(it) }
    }
}
