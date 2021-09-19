package com.fonteraro.martaco.cinemahub.ui.splash

import android.annotation.SuppressLint
import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.fonteraro.martaco.cinemahub.BR
import com.fonteraro.martaco.cinemahub.ui.main.MainActivity
import com.fonteraro.martaco.cinemahub.R
import com.fonteraro.martaco.cinemahub.databinding.ActivitySplashBinding
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goToMainActivity()
    }

    private fun goToMainActivity() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }, 2000)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel {
        val splashViewModel: SplashViewModel by viewModels { viewModelFactory }
        return splashViewModel
    }
}
