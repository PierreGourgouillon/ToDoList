package com.example.app_todolist.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ToDo implements Parcelable {
    private int id;
    private String title;
    private String description;
    private String hours;
    private boolean isComplete;

    public ToDo(String title, String description, String hours){
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.isComplete = false;
    }

    protected ToDo(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        hours = in.readString();
        isComplete = in.readByte() != 0;
    }

    public static final Creator<ToDo> CREATOR = new Creator<ToDo>() {
        @Override
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        @Override
        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHours() {
        return hours;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", hours='" + hours + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(hours);
        parcel.writeByte((byte) (isComplete ? 1 : 0));
    }
}
