package com.example.claudiabee.listentoastory;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define global variables
    private TextView libraryTextView;
    private TextView audioFileProviderInfoTextView;
    private TextView authorSearchTextView;
    private TextView authorInfoTextView;
    private final String lVHomeUrl = "https://librivox.org/";
    public final String aesopFable = "Aesop fable";
    public final String wHomeUrl = "https://en.wikipedia.org/wiki/Aesop";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view with ID library and instantiate it in a TextView object
        libraryTextView = findViewById(R.id.library);
        // Set an onClickListener to this view so that so that an explicit intent is sent when
        // libraryTextView is clicked
        libraryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LibraryActivity.class);
                startActivity(i);
            }
        });

        // Find the view with ID audio_file_provider_info and instantiate it in a TextView object
        audioFileProviderInfoTextView = findViewById(R.id.audio_file_provider_info);
        // Set an onClickListener to this view so that so that an implicit intent is sent to open a
        // web page when audioFileProviderInfoTextView is clicked
        audioFileProviderInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThisWebPage(lVHomeUrl);
            }
        });

        // Find the view with ID author_search and instantiate it in a TextView object
        authorSearchTextView = findViewById(R.id.author_search);
        // Set an onClickListener to this view so that  when authorSearchTextView is clicked
        // an implicit intent is sent to open a search on the web
        authorSearchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTheWeb(aesopFable);
            }
        });

        // Find the view with ID author_info and instantiate it in a TextView object
        authorInfoTextView = findViewById(R.id.author_info);
        // Set an onClickListener to this view so that  when authorInfoTextView is clicked
        // an implicit intent is sent to open a web page
        authorInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThisWebPage(wHomeUrl);
            }
        });
    }

    public void searchTheWeb(String query) {
        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
        i.putExtra(SearchManager.QUERY, query);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    public void openThisWebPage(String url) {
        Uri webPage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, webPage);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}
