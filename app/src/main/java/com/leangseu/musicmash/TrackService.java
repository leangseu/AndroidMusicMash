package com.leangseu.musicmash;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface TrackService {

    @GET("/v2.0/tracks/top")
    public void getTopTracks(
            @Query(Constants.APIKEY) String apikey,
            @Query(Constants.LIMIT) int limit,
            Callback<Tracks> callback);

//    @GET("/v2.0/me/listens")
//    public void getListeningHistory(
//            @Header(Constants.AUTHORIZAION) String authorization,
//            Callback<Tracks> callback);

}
