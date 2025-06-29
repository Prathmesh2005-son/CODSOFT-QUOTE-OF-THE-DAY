package com.example.quoteoftheday;


import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class QuoteManager {
    private final String[] quotes = {
            "Believe in yourself!",
            "Every day is a second chance.",
            "Push yourself, because no one else will.",
            "Success is not final, failure is not fatal.",
            "Stay hungry. Stay foolish.",
            "The best time for new beginnings is now.",
            "Don’t stop until you’re proud."
    };

    private final SharedPrefHelper prefHelper;

    public QuoteManager(Context context) {
        this.prefHelper = new SharedPrefHelper(context);
    }

    public String getTodaysQuote() {
        String lastDate = prefHelper.getSavedDate();
        String today = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());

        if (!today.equals(lastDate)) {
            int index = new Random().nextInt(quotes.length);
            String quote = quotes[index];
            prefHelper.saveQuoteOfDay(quote, today);
            return quote;
        } else {
            return prefHelper.getQuoteOfDay();
        }
    }
}
