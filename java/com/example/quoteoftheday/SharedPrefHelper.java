package com.example.quoteoftheday;


import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

public class SharedPrefHelper {
    private static final String PREF_NAME = "DailyInspirationPrefs";
    private final SharedPreferences prefs;

    public SharedPrefHelper(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveQuoteOfDay(String quote, String date) {
        prefs.edit().putString("quote", quote).putString("date", date).apply();
    }

    public String getQuoteOfDay() {
        return prefs.getString("quote", "Stay motivated!");
    }

    public String getSavedDate() {
        return prefs.getString("date", "");
    }

    public void saveFavorite(String quote) {
        Set<String> favs = getFavorites();
        favs.add(quote);
        prefs.edit().putStringSet("favorites", favs).apply();
    }

    public Set<String> getFavorites() {
        return new HashSet<>(prefs.getStringSet("favorites", new HashSet<>()));
    }
}
