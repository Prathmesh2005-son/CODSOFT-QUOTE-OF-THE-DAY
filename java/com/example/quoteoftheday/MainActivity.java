package com.example.quoteoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView quoteTextView;
    ImageButton shareButton, favoriteButton, viewFavoritesButton;
    String currentQuote;
    QuoteManager quoteManager;
    SharedPrefHelper prefHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        shareButton = findViewById(R.id.shareButton);
        favoriteButton = findViewById(R.id.favoriteButton);
        viewFavoritesButton = findViewById(R.id.viewFavoritesButton);

        quoteManager = new QuoteManager(this);
        prefHelper = new SharedPrefHelper(this);

        currentQuote = quoteManager.getTodaysQuote();
        quoteTextView.setText(currentQuote);

        shareButton.setOnClickListener(view -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);
            startActivity(Intent.createChooser(shareIntent, "Share Quote via"));
        });

        favoriteButton.setOnClickListener(view -> {
            prefHelper.saveFavorite(currentQuote);
            Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
        });

        viewFavoritesButton.setOnClickListener(view ->
                startActivity(new Intent(this, FavoriteQuotesActivity.class))
        );
    }
}
