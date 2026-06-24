package de.thnuernberg.bme.flashquest.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PointsManager {

    private static final String PREFS_NAME = "FlashQuestPrefs";
    private static final String KEY_POINTS = "points";

    public static int getPoints(Context context) {

        SharedPreferences prefs =
                context.getSharedPreferences(
                        PREFS_NAME,
                        Context.MODE_PRIVATE
                );

        return prefs.getInt(KEY_POINTS, 0);
    }

    public static void addPoints(
            Context context,
            int amount
    ) {

        SharedPreferences prefs =
                context.getSharedPreferences(
                        PREFS_NAME,
                        Context.MODE_PRIVATE
                );

        int currentPoints =
                prefs.getInt(KEY_POINTS, 0);

        prefs.edit()
                .putInt(
                        KEY_POINTS,
                        currentPoints + amount
                )
                .apply();
    }

    public static void resetPoints(Context context) {

        SharedPreferences prefs =
                context.getSharedPreferences(
                        PREFS_NAME,
                        Context.MODE_PRIVATE
                );

        prefs.edit()
                .putInt(KEY_POINTS, 0)
                .apply();
    }
}