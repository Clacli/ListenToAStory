package com.example.claudiabee.listentoastory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.claudiabee.listentoastory.Fable;
import com.example.claudiabee.listentoastory.R;

import java.util.ArrayList;

/**
 * {@link FableAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Fable} objects.
 */
public class FableAdapter extends ArrayAdapter<Fable> {

    /**
     * Create a new {@link FableAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param fables  is the list of {@link Fable}s to be displayed.
     */
    public FableAdapter(Context context, ArrayList<Fable> fables) {
        super(context, 0, fables);
    }

    /**
     * Provides a view for an adapterView(ListView, it could be a GridView)
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fable_list_item, parent, false);
        }

        // Get the {@link Fable} object located at this position in the list
        Fable currentFable = getItem(position);

        //Find the View in the list item
        View fableContainerView = listItemView.findViewById(R.id.fable_container);

        //Find the TextView in the fable_list_item.xml layout with ID fable_title
        TextView fableTitleTextView = listItemView.findViewById(R.id.fable_title);
        // Get the title of the fable from the currentFable object and set this text
        //on the fableTitleTextView
        fableTitleTextView.setText(currentFable.getFableTitle());

        // Find the TextView in the fable_list_item.xml layout with ID reader_name
        TextView readerNameTextView = listItemView.findViewById(R.id.reader_name);
        // Get the reader's name from the currentFable object and set this text
        // in the readerNameTextView
        readerNameTextView.setText(currentFable.getReaderName());

        // Find the TextView in the fable_list_item.xml layout with ID book_title
        TextView bookTitleTextView = listItemView.findViewById(R.id.book_title);
        // Get the title of the book from the current Fable object and set this text
        // in the bookTitletextView
        bookTitleTextView.setText(currentFable.getBookTitle());

        // Find the textView in the fable_list_item.xml layout with ID duration
        TextView fableDurationTextView = listItemView.findViewById(R.id.duration);
        // Get the duration of the fable audio file from the current Fable object and set this text
        // in the fableDurationTextView
        fableDurationTextView.setText(currentFable.getAudioDuration());

        // Return the whole list item layout (containing an ImageView and four TextView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
