package com.regadeveloper.mysubmission;

import android.os.Parcel;
import android.os.Parcelable;

public class Khilafah implements Parcelable {


    //POJO (Plain Of Java Objek)
    private String khilafah;
    private String data;
    private int photo;

    protected Khilafah(Parcel in) {
        khilafah = in.readString();
        data = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Khilafah> CREATOR = new Creator<Khilafah>() {
        @Override
        public Khilafah createFromParcel(Parcel in) {
            return new Khilafah(in);
        }

        @Override
        public Khilafah[] newArray(int size) {
            return new Khilafah[size];
        }
    };

    public Khilafah() {

    }

    public String getKhilafah() {
        return khilafah;
    }

    public void setKhilafah(String khilafah) {
        this.khilafah = khilafah;
    }

    public String getDes() {
        return data;
    }

    public void setDes(String data) {
        this.data = data;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(khilafah);
        parcel.writeString(data);
        parcel.writeInt(photo);
    }
}

