package com.example.kshah97.nytimessearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by kshah97 on 6/20/16.
 */

@Parcel
public class Article{

    String webUrl;

    public String getHeadline() {
        return headline;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public String getWebUrl() {
        return webUrl;
    }

    String headline;
    String thumbNail;

    public Article(){

    }


    public Article(JSONObject jsonObject) {

        try{

        this.webUrl = jsonObject.getString("web_url");
        this.headline = jsonObject.getJSONObject("headline").getString("main");

        JSONArray multimedia = jsonObject.getJSONArray("multimedia");

        if(multimedia.length() > 0) {
            JSONObject multimediaJson = multimedia.getJSONObject(0);
            this.thumbNail = "http://www.nytimes.com/" + multimediaJson.getString("url");


        } else {
            this.thumbNail = "";
        }
        }

        catch (JSONException e) {

        }



    }


    public static ArrayList<Article> fromJSONArray(JSONArray array) {
        ArrayList<Article> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++) {

            try{

                results.add(new Article(array.getJSONObject(i)));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return results;

    }
}
