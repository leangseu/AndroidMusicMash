package com.leangseu.musicmash;

import android.app.Application;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.napster.cedar.Napster;
import com.napster.cedar.player.Player;
import com.napster.cedar.player.data.Track;

import java.util.List;
import java.util.zip.Inflater;

import static android.R.id.list;
import static com.leangseu.musicmash.Constants.NAPSTER_API_KEY;

/**
 * Created by leangseu on 10/8/17.
 */

public class TrackAdapter extends ArrayAdapter<Track> {

    public static Napster napster = null;


    public TrackAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Track> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View listView = convertView;

        final Track track = getItem(position);

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.track_layout, parent, false);
        }

        TextView titleTV = (TextView) listView.findViewById(R.id.track_title);
        TextView authorTV = (TextView) listView.findViewById(R.id.track_author);

        titleTV.setText(track.name);
        authorTV.setText(track.artistName);


//        Napster napster = Napster.register(getContext(), Constants.NAPSTER_API_KEY, Constants.NAPSTER_API_SECRET_KEY);
//        final Player player = napster.getPlayer();
        if (napster == null) {
            napster = Napster.register(parent.getContext(), Constants.NAPSTER_API_KEY, Constants.NAPSTER_API_SECRET_KEY);
        }

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("cc", track.name);
                napster.getPlayer().play(track);
            }
        });

        return listView;
    }
}
