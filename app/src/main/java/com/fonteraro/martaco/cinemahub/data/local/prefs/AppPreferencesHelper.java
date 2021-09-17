package com.fonteraro.martaco.cinemahub.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.fonteraro.martaco.cinemahub.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_REFRESH_TIMESTAMP = "PREF_KEY_REFRESH_TIMESTAMP";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getLastRefreshTimestamp() {
        return mPrefs.getLong(PREF_KEY_REFRESH_TIMESTAMP, 0L);
    }

    @Override
    public void setLastRefreshTimestamp(long timestamp) {
        mPrefs.edit().putLong(PREF_KEY_REFRESH_TIMESTAMP, timestamp).apply();
    }
}
