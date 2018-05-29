package com.example.claudiabee.listentoastory;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    // Define global variables of the class
    private TextView titleOfBookTextView;
    private TextView titleOfFableTextView;
    private TextView readerNameTextView;

    private Button playButton;
    private Button pauseButton;

    private String fableTitle;
    private String readerName;
    private String bookTitle;
    int fableRawResourceId;

    private MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Find the view with ID title_of_the_fable and instantiate it in a TextView object
        titleOfFableTextView = (TextView) findViewById(R.id.title_of_the_fable);
        // Find the view with ID name_of_the_reader and instantiate it in a TextView object
        readerNameTextView = (TextView) findViewById(R.id.name_of_the_reader);
        // Find the view with ID title_of_the_book and instantiate it in a TextView object
        titleOfBookTextView = (TextView) findViewById(R.id.title_of_the_book);
        // Find the view button with ID play_button and  create an instance of it as a button object
        playButton = (Button) findViewById(R.id.play_button);
        // Find the button with ID pause_button and  create an instance of it as a button object
        pauseButton = (Button) findViewById(R.id.pause_button);

        // Get the intent that started the activity and store it in a variable
        Intent i = getIntent();

        // Retrieve the String with the title of the fable passed from LibraryActivity to this Activity
        // and set its text in the titleOfFableTextView
        fableTitle = i.getStringExtra("fableTitle");
        if (fableTitle != null) {
            titleOfFableTextView.setText(fableTitle);
        }

        // Retrieve the String with the name of the reader passed from LibraryActivity to this Activity
        // and set its text in the readerNameTextView
        readerName = i.getStringExtra("readerName");
        if (readerName != null) {
            readerNameTextView.setText(readerName);
        }

        // Retrieve the String with the title of the book passed from LibraryActivity to this Activity
        // and set its text in the titleOfBookTextView
        bookTitle = i.getStringExtra("bookTitle");
        if (bookTitle != null) {
            titleOfBookTextView.setText(bookTitle);
        }

        // Retrieve the raw resource ID for the Fable object chosen in the LibraryActivity
        fableRawResourceId = i.getIntExtra("fableRawResourceId", 0);

        // Release mediaplayer resources
        //releaseMyMediaPlayer();

        // Create a MediaPlayer instance and store it in myMediaPlayer variable
        myMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, fableRawResourceId);

        // TODO: Manage playback state on change configuration

        // TODO: Add an AudioManager

        // Set an onclick listener on the playButton object
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.start();
                myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMyMediaPlayer();
                    }
                });
            }
        });

        // Set an onclick listener on the pauseButton object
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.pause();
            }
        });
    }

    // Release myMediaPlayer resources when the NowPlayingActivity is no longer visible on the screen
    @Override
    protected void onStop() {
        super.onStop();
        releaseMyMediaPlayer();
    }

    public void releaseMyMediaPlayer() {
        if (myMediaPlayer != null) {
            // Release myMediaPlayer object and its associated resources
            myMediaPlayer.release();
            // Set myMediaPlayer object to null
            myMediaPlayer = null;

            Toast.makeText(getApplicationContext(), "Playback completed", Toast.LENGTH_SHORT).show();
        }
    }
}
