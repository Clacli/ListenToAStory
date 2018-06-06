package com.example.claudiabee.listentoastory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link FableAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Fable} objects.
 */
public class FableAdapter extends ArrayAdapter<Fable> {

    FableViewHolder holder;

    /**
     * Provides a view for an adapterView(ListView, it could be a GridView)
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fable_list_item, parent, false);

            // Set the view ViewHolder
            holder = new FableViewHolder();
            holder.fableTitleTextView = convertView.findViewById(R.id.fable_title);
            holder.readerNameTextView = convertView.findViewById(R.id.reader_name);
            holder.bookTitleTextView = convertView.findViewById(R.id.book_title);
            holder.fableDurationTextView = convertView.findViewById(R.id.duration);
            convertView.setTag(holder);
        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            holder = (FableViewHolder) convertView.getTag();
        }

        // Get the {@link Fable} object located at this position in the list
        Fable currentFable = getItem(position);

        // Get the title of the fable from the currentFable object and set this text
        //on the fableTitleTextView
        holder.fableTitleTextView.setText(currentFable.getFableTitle());

        // Get the reader's name from the currentFable object and set this text
        // in the readerNameTextView
        holder.readerNameTextView.setText(currentFable.getReaderName());

        // Get the title of the book from the current Fable object and set this text
        // in the bookTitletextView
        holder.bookTitleTextView.setText(currentFable.getBookTitle());

        // Get the duration of the fable audio file from the current Fable object and set this text
        // in the fableDurationTextView
        holder.fableDurationTextView.setText(currentFable.getAudioDuration());

        // Return the whole list item layout (containing an ImageView and four TextView)
        // so that it can be shown in the ListView
        return convertView;
    }

    /**
     * Create a new {@link FableAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param fables  is the list of {@link Fable}s to be displayed.
     */
    public FableAdapter(Context context, ArrayList<Fable> fables) {
        super(context, 0, fables);
    }

    //
    static class FableViewHolder {
        TextView fableTitleTextView;
        TextView readerNameTextView;
        TextView bookTitleTextView;
        TextView fableDurationTextView;
    }
}
