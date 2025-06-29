package com.example.quoteoftheday;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FavoriteQuotesActivity extends AppCompatActivity {
    ListView favListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_quotes);

        favListView = findViewById(R.id.favListView);
        SharedPrefHelper prefHelper = new SharedPrefHelper(this);
        ArrayList<String> favList = new ArrayList<>(prefHelper.getFavorites());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, favList);
        favListView.setAdapter(adapter);
    }
}
