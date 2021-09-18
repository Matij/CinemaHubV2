package com.fonteraro.martaco.cinemahub.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.fonteraro.martaco.cinemahub.BR;
import com.fonteraro.martaco.cinemahub.R;
import com.fonteraro.martaco.cinemahub.databinding.ActivitySplashBinding;
import com.fonteraro.martaco.cinemahub.ui.base.BaseActivity;
import com.fonteraro.martaco.cinemahub.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> {

    @Inject
    SplashViewModel mSplashViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goToMainActivity();
    }

    private void goToMainActivity() {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }, 2000);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }
}
