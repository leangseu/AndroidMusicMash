package com.leangseu.musicmash;

import com.napster.cedar.Napster;
import com.napster.cedar.internal.service.StationService;
import com.napster.cedar.player.Player;

import retrofit.RestAdapter;
import retrofit.Callback;


public class Metadata {

    TrackService trackService;
    String apiKey;

    public Metadata(String apiKey) {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Constants.URL).build();
        trackService = adapter.create(TrackService.class);
        this.apiKey = apiKey;
    }

    public void getTopTracks(Callback<Tracks> callback) {
        trackService.getTopTracks(apiKey, 20, callback);
    }

    public TrackService getTrackService() {
        return trackService;
    }

}
