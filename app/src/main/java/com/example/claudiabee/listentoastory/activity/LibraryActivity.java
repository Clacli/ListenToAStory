package com.example.claudiabee.listentoastory.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.claudiabee.listentoastory.Fable;
import com.example.claudiabee.listentoastory.FableAdapter;
import com.example.claudiabee.listentoastory.R;

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
        fables.add(new Fable("The Fox and The Stork", "Kristin LeMoine", "Aesop's Fables Vol 02,\n(Fables 26-50)", R.raw.the_fox_and_the_stork, "00:01:11"));
        fables.add(new Fable("The Wolf in Sheep’s Clothing", "Kristin LeMoine", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_wolf_in_sheeps_clothing, "00:01:04"));
        fables.add(new Fable("The Stag in the Ox-Stall", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_stag_in_the_ox_stall, "00:02:15"));
        fables.add(new Fable("The Milkmaid and Her Pail", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_milkmaid_and_her_pail, "00:01:42"));
        fables.add(new Fable("The Dolphins, The Whales, and The Sprat", "Annie Coleman Rothenberg", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_dolphin_the_whales_and_the_sprat, "00:01:04"));
        fables.add(new Fable("The Fox and The Monkey", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fox_and_the_monkey, "00:01:14"));
        fables.add(new Fable("The Ass and The Lap-Dog", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_ass_and_the_lap_dog, "00:02:03"));
        fables.add(new Fable("The Fir-Tree and The Bramble", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fir_tree_and_the_bramble, "00:01:14"));
        fables.add(new Fable("The Frogs’ Complaint Against The Sun", "ajfluke", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_frogs_complaint_against_the_sun, "00:01:02"));
        fables.add(new Fable("The Dog, The Cock, and The Fox", "Desdemona", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_dog_the_cock_and_the_fox, "00:01:04"));
        fables.add(new Fable("The Gnat and The Bull", "Desdemona", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_gnat_and_the_bull, "00:00:48"));
        fables.add(new Fable("The Bear and The Travellers", "Desdemona", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_bear_and_the_travelles, "00:01:14"));
        fables.add(new Fable("The Slave and The Lion", "Basil Monroe Godevenos", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_slave_and_the_lion, "00:02:21"));
        fables.add(new Fable("The Flea and The Man", "Basil Monroe Godevenos", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_flea_and_the_man, "00:01:22"));
        fables.add(new Fable("The Bee and Jupiter", "Basil Monroe Godevenos", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_bee_and_jupiter, "00:01:11"));
        fables.add(new Fable("The Oak and The Reeds", "phoenixascending", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_oak_and_the_reeds, "00:01:02"));
        fables.add(new Fable("The Blind Man and The Cub", "phoenixascending", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_blind_man_and_the_cub, "00:00:56"));
        fables.add(new Fable("The Boy and The Snails", "phoenixascending", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_boy_and_the_snails, "00:00:56"));
        fables.add(new Fable("The Apes and The Two Travellers", "Rainer", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_apes_and_the_two_travellers, "00:02:06"));
        fables.add(new Fable("The Ass and His Burden", "Patrick McNeal", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_ass_and_his_burden, "00:01:24"));
        fables.add(new Fable("The Sheperd\'s Boy and The Wolf", "Sara Schein", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_sheperds_boy_and_the_wolf, "00:01:29"));
        fables.add(new Fable("The Fox and The Goat", "Sara Schein", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fox_and_the_goat, "00:01:29"));
        fables.add(new Fable("The Fisherman and The Sprat", "Gesine", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_fisherman_and_the_sprat, "00:01:14"));
        fables.add(new Fable("The Boasting Traveller", "Patrick McNeal", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_boasting_traveller, "00:00:56"));
        fables.add(new Fable("The Crab and His Mother", "Robert Garrison", "Aesop's Fables, Volume 02,\n(Fables 26-50)", R.raw.the_crab_and_his_mother, "00:00:57"));

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
                Log.d("LibraryActivity", "current Fable" + currentFable.toString());
                // Send an explicit intent to open NowPlaying activity
                Intent i = new Intent(getApplicationContext(), NowPlayingActivity.class);
                i.putExtra("fableTitle", currentFable.getFableTitle());
                i.putExtra("readerName", currentFable.getReaderName());
                i.putExtra("bookTitle", currentFable.getBookTitle());
                int audioResId = currentFable.getAudioResourceId();
                i.putExtra("fableRawResourceId", audioResId);
                startActivity(i);

            }
        });

        // Change color to list item divider
        ColorDrawable myColorDivider = new ColorDrawable(
                this.getResources().getColor(R.color.library_list_item_divider));
        listItemView.setDivider(myColorDivider);
        listItemView.setDividerHeight(1);
    }
}


