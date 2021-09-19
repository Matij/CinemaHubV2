package com.fonteraro.martaco.cinemahub.ui.details

import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.activity.viewModels
import com.fonteraro.martaco.cinemahub.BR
import com.fonteraro.martaco.cinemahub.utils.AppConstants
import com.fonteraro.martaco.cinemahub.R
import com.fonteraro.martaco.cinemahub.databinding.ActivityDetailsBinding
import javax.inject.Inject

class DetailsActivity : BaseActivity<ActivityDetailsBinding, DetailsViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding!!.lifecycleOwner = this
        fetchMovie()
    }

    private fun fetchMovie() {
        val movieId = retrieveMovieId()
        if (movieId != -1L) viewModel.getMovieDetails(movieId)
    }

    private fun retrieveMovieId(): Long {
        return intent.getLongExtra(AppConstants.EXTRA_KEY_MOVIE_ID, -1)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_details
    }

    override fun getViewModel(): DetailsViewModel {
        val detailsViewModel: DetailsViewModel by viewModels { viewModelFactory }
        return detailsViewModel
    }
}
