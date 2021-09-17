package com.fonteraro.martaco.cinemahub.ui.main;

import com.fonteraro.martaco.cinemahub.data.DataRepository;
import com.fonteraro.martaco.cinemahub.ui.base.BaseViewModel;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    @Inject
    public MainViewModel(DataRepository dataRepository) {
        super(dataRepository);
    }
}
