package com.fonteraro.martaco.cinemahub.data.local.prefs;

public interface PreferencesHelper {

    Long getLastRefreshTimestamp();

    void setLastRefreshTimestamp(long timestamp);
}
