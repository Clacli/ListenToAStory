package com.example.claudiabee.listentoastory.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.claudiabee.listentoastory.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private final String aesopFable = "Aesop fable";
    private final String wHomeUrl = "https://en.wikipedia.org/wiki/Aesop";
    private final String lVHomeUrl = "https://librivox.org/";
    //Bind views with Butter Knife and cast views in layout
    @BindView(R.id.library)
    TextView libraryTextView;
    @BindView(R.id.audio_file_provider_info)
    TextView audioFileProviderInfoTextView;
    @BindView(R.id.author_search)
    TextView authorSearchTextView;
    @BindView(R.id.author_info)
    TextView authorInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Set an onClickListener to this view so that so that an explicit intent is sent when
        // libraryTextView is clicked
        libraryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LibraryActivity.class);
                startActivity(i);
            }
        });

        // Set an onClickListener to this view so that so that an implicit intent is sent to open a
        // web page when audioFileProviderInfoTextView is clicked
        audioFileProviderInfoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThisWebPage(lVHomeUrl);
            }
        });

        // Set an onClickListener to this view so that  when authorSearchTextView is clicked
        // an implicit intent is sent to open a search on the web
        authorSearchTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTheWeb(aesopFable);
            }
        });

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
