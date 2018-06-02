package com.example.claudiabee.listentoastory;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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

    // Create a seekbar as a member variable (I)
    private SeekBar seekbar;
    // Create a handler to constantly update the seekbar (I)
    private Handler mSeekbarHandler = new Handler();

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMyMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mMyAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AudioManager.AUDIOFOCUS_GAIN:
                            // Start playback of the fable audio file
                            mMyMediaPlayer.start();
                            mMyMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                            mMyMediaPlayer.pause();
                            // Start audio file from the beginning
                            mMyMediaPlayer.seekTo(0);
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMyMediaPlayer.pause();
                            // Start audio file from the beginning
                            mMyMediaPlayer.seekTo(0);
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            // Abandon audiofocus and clean up resource when playback is done
                            releaseMyMediaPlayer();
                    }
                }
            };

    // Create a SeekBar.OnSeekBarChangeListener to seek the raw file to a particular time
    // to seek the position where the seek bar pointer is
    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        mMyMediaPlayer.seekTo(progress);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };



    private MediaPlayer.OnCompletionListener mOnCompletionListener =
            new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMyMediaPlayer();
            // Remove the handler (I)
            mSeekbarHandler.removeCallbacks(mUpdateAudioSeekbar);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Create and set up the {@link AudioManager} to request audio focus
        mMyAudioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

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
        final Intent i = getIntent();

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

        // TODO: Manage playback state on change configuration

        // Set an onclick listener on the playButton object
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Retrieve the raw resource ID for the Fable object chosen in the LibraryActivity
                fableRawResourceId = i.getIntExtra("fableRawResourceId", 0);

                if (mMyMediaPlayer == null) {
                    // Request audio focus so in order to play the audio file. The app needs to play a
                    // audio files which last for some minutes, so request audio docus with AUDIOFOCUS_GAIN.
                    int resultOfAudioFocusRequest = mMyAudioManager.requestAudioFocus(mAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN);

                    if (resultOfAudioFocusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        // We have audiofocus now

                        seekbar = (SeekBar) findViewById(R.id.seekbar);
                        seekbar.setClickable(false);
                        seekbar.setBackgroundResource(R.color.info_on_resource_provider);

                        // Create and setup the {@link Mediaplayer} for the audio associated with the
                        // raw resource ID
                        mMyMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, fableRawResourceId);

                        // Set the max value for the seekbar geting duration of the playback (I)
                        seekbar.setMax(mMyMediaPlayer.getDuration());

                        // Start playback
                        mMyMediaPlayer.start();

                        // Call the handler when audio starts to play (I)
                        mSeekbarHandler.postDelayed(mUpdateAudioSeekbar, 0);

                        // Seek to the position where the seek bar pointer is
                        seekbar.setOnSeekBarChangeListener(mOnSeekBarChangeListener);

                        // Release resources and audiofocus when playback is completed
                        mMyMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                    }
                } else {
                    mMyMediaPlayer.start();
                }
            }
        });

        // Set an onclick listener on the pauseButton object
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyMediaPlayer.pause();
            }
        });
    }

    // Release mMyMediaPlayer resources when the NowPlayingActivity is no longer visible on the screen
    @Override
    protected void onStop() {
        super.onStop();
        releaseMyMediaPlayer();
        // Remove the handler (I)
        mSeekbarHandler.removeCallbacks(mUpdateAudioSeekbar);

    }

    // Release MediaPlayer resources and and set it to null
    public void releaseMyMediaPlayer() {
        if (mMyMediaPlayer != null) {
            // Release mMyMediaPlayer object and its associated resources
            mMyMediaPlayer.release();
            // Set mMyMediaPlayer object to null
            mMyMediaPlayer = null;
            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the mAudioFocusChangeListener so we don't get anymore callbacks.
            // mMyAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
            mMyAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

    // This runnable helps the handler to update the seekbar (I)
    private Runnable mUpdateAudioSeekbar = new Runnable() {
        @Override
        public void run(){
            seekbar.setProgress(mMyMediaPlayer.getCurrentPosition());
            // the handler updates the seek every 50ms
            mSeekbarHandler.postDelayed(this, 50);
        }
    };
}
