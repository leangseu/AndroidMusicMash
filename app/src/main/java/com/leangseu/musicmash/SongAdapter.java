package com.leangseu.musicmash;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by leangseu on 10/7/17.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;

        Song song = getItem(position);
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(R.layout.song_layout, parent, false);
        }

        TextView title = (TextView) gridView.findViewById(R.id.song_title);
        ImageView image = (ImageView) gridView.findViewById(R.id.song_image);
        TextView author = (TextView) gridView.findViewById(R.id.song_author);

        title.setText(song.getTitle());
        image.setImageURI(Uri.parse(song.getImage()));
        author.setText(song.getAuthor());

        return gridView;
    }
}
