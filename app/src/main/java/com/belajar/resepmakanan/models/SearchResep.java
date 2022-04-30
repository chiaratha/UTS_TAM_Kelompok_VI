package com.belajar.resepmakanan.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResep implements Parcelable {
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("results")
    @Expose
    private ArrayList<ResultSearch> results = null;

    protected SearchResep(Parcel in) {
        method = in.readString();
        byte tmpStatus = in.readByte();
        status = tmpStatus == 0 ? null : tmpStatus == 1;
    }

    public static final Creator< SearchResep > CREATOR = new Creator< SearchResep >() {
        @Override
        public SearchResep createFromParcel(Parcel in) {
            return new SearchResep(in);
        }

        @Override
        public SearchResep[] newArray(int size) {
            return new SearchResep[size];
        }
    };

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList< ResultSearch > getResults() {
        return results;
    }

    public void setResults(ArrayList< ResultSearch > results) {
        this.results = results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(method);
        parcel.writeByte((byte) (status == null ? 0 : status ? 1 : 2));
    }
}
