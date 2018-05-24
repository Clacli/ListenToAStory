package com.example.claudiabee.listentoastory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define global variables
    private TextView libraryTextView;
    private TextView audioFileProviderInfo;
    private TextView authorSearchTextView;
    private TextView authorInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view with ID library and instantiate it in a TextView object
        libraryTextView = findViewById(R.id.library);
        // Find the view with ID audio_file_provider_info and instantiate it in a TextView object
        audioFileProviderInfo = findViewById(R.id.audio_file_provider_info);
        // Find the view with ID author_search and instantiate it in a TextView object
        authorSearchTextView = findViewById(R.id.author_search);
        // Find the view with ID author_info and instantiate it in a TextView object
        authorInfo = findViewById(R.id.author_info);
    }
}
