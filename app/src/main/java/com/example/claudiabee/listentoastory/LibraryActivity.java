package com.example.claudiabee.listentoastory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * This  displays a list of songs
 */
public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        final ArrayList<Fable> fables = new ArrayList<Fable>();
        fables.add(new Fable("The Fox and The Stork", "Kristin LeMoine", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fox_and_the_stork, "00:01:11"));
        fables.add(new Fable("The Wolf in Sheep’s Clothing", "Kristin LeMoine", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_wolf_in_sheeps_clothing, "00:01:04"));
        fables.add(new Fable("The Stag in the Ox-Stall", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_stag_in_the_ox_stall, "00:02:15"));
        fables.add(new Fable("The Milkmaid and Her Pail", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_milkmaid_and_her_pail, "00:01:42"));
        fables.add(new Fable("The Dolphins, The Whales, and The Sprat", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_dolphin_the_whales_and_the_sprat, "00:01:04"));
        fables.add(new Fable("The Fox and The Monkey", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fox_and_the_monkey, "00:01:14"));
        fables.add(new Fable("The Ass and The Lap-Dog", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_ass_and_the_lap_dog, "00:02:03"));
        fables.add(new Fable("The Fir-Tree and The Bramble", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fir_tree_and_the_bramble, "00:01:14"));
        fables.add(new Fable("The Frogs’ Complaint Against The Sun", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_frogs_complaint_against_the_sun, "00:01:02"));
        fables.add(new Fable("The Dog, The Cock, and The Fox", "Desdemona", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_dog_the_cock_and_the_fox, "00:01:04"));


        // Find a reference to the {@link ListView} in the layout and store it in an object variable
        ListView listItemView = findViewById(R.id.fable_list);

        // Create a new {@link ArrayAdapter} of songs.
        // The adapter know how to display the songs in the list
        FableAdapter adapter =
                new FableAdapter(this, fables);

        // Hook the list to the adapter, calling setAdapter method on the {@link Listview},
        // so that the list can be populated in the user interface
        listItemView.setAdapter(adapter);

        listItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Word} object at the given position the user clicked on
                Fable currentFable = fables.get(position);
                // Log.d("MainActivity", "current Fable" + currentFable.toString());
                // Send an explicit intent to open NowPlaying activity
                Intent i = new Intent(getApplicationContext(), NowPlayingActivity.class);
                i.putExtra("fableTitle", currentFable.getFableTitle());
                i.putExtra("readerName", currentFable.getReaderName());
                i.putExtra("bookTitle", currentFable.getBookTitle());
                int audioResId = currentFable.getAudioResourceId();
                i.putExtra("fableResourceId", audioResId);
                startActivity(i);

            }
        });
    }
}


