package com.belajar.resepmakanan.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultSearch implements Parcelable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("times")
    @Expose
    private String times;
    @SerializedName("serving")
    @Expose
    private String serving;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    protected ResultSearch(Parcel in) {
        title = in.readString();
        thumb = in.readString();
        key = in.readString();
        times = in.readString();
        serving = in.readString();
        difficulty = in.readString();
    }

    public static final Creator< ResultSearch > CREATOR = new Creator< ResultSearch >() {
        @Override
        public ResultSearch createFromParcel(Parcel in) {
            return new ResultSearch(in);
        }

        @Override
        public ResultSearch[] newArray(int size) {
            return new ResultSearch[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getServing() {
        return serving;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(thumb);
        parcel.writeString(key);
        parcel.writeString(times);
        parcel.writeString(serving);
        parcel.writeString(difficulty);
    }
}
