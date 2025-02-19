package org.lineageos.settings.device.utils;

import android.content.SharedPreferences;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;

import androidx.preference.PreferenceManager;

import org.lineageos.settings.device.Constants;
import org.lineageos.settings.device.utils.FileUtils;

public class DisplayUtils {

    public static void updateRefreshRateSettings(final Context context) {
        Handler.getMain().post(() -> {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String[] refreshRateSettings = sharedPreferences.getString(
            Constants.KEY_REFRESH_RATE_CONFIG, Constants.DEFAULT_REFRESH_RATE_CONFIG).split("-");

        Settings.System.putFloat(context.getContentResolver(),
            Settings.System.MIN_REFRESH_RATE, Float.valueOf(refreshRateSettings[0]));
        Settings.System.putFloat(context.getContentResolver(),
            Settings.System.PEAK_REFRESH_RATE, Float.valueOf(refreshRateSettings[1]));
        });
    }
}
