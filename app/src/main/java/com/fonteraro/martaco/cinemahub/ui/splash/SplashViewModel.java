package com.fonteraro.martaco.cinemahub.ui.splash;

import com.fonteraro.martaco.cinemahub.data.DataRepository;
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel;

import javax.inject.Inject;

public class SplashViewModel extends BaseViewModel {

    @Inject
    public SplashViewModel(DataRepository dataRepository) {
        super(dataRepository);
    }
}
