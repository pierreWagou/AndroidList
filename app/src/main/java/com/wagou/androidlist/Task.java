package com.wagou.androidlist;

import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }
        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    private String libelle;
    private Boolean statut;
    private String priorite;
    private String date;

    public Task() {
        libelle = new String("");
        statut = new Boolean(false);
        priorite = new String("Moyenne");
        date = new String("");
    }

    public Task(Parcel source) {
        libelle = source.readString();
        priorite = source.readString();
        statut = source.readByte()!=0;
        date  = source.readString();
    }

    String getLibelle() {
        return libelle;
    }

    void setLibelle(String l) {
        libelle = l;
    }

    void setStatut(Boolean s) {
        statut = s;
    }

    String getPriorite() {
        return priorite;
    }

    void setPriorite(String p) {
        priorite = p;
    }

    String getDate() {
        return date;
    }

    void setDate(String d) {
        date = d;
    }

    int getImageDrawable() {
        if(statut) {
            return R.drawable.ic_check_black_24dp;
        }
        else {
            return R.drawable.ic_access_time_black_24dp;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString((libelle));
        dest.writeString(priorite);
        dest.writeByte((byte) (statut ? 1:0));
        dest.writeString(date);
    }
}
