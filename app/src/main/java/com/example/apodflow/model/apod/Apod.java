package com.example.apodflow.model.apod;

import android.os.Parcel;
import android.os.Parcelable;

public class Apod implements Parcelable {

    private String explanation;
    private String hdurl;
    private String title;
    private String url;
    private String date;
    private String start_date;
    private String end_date;
    private  int count;

    public Apod(String start_date, String end_date) {
        this.start_date = start_date;
        this.end_date = end_date;
    }


    public Apod(String date) {
        this.date = date;
    }

    public Apod(int count) {
        this.count = count;
    }

    protected Apod(Parcel in) {
        explanation = in.readString();
        hdurl = in.readString();
        title = in.readString();
        date = in.readString();
        start_date = in.readString();
        end_date = in.readString();
        count = in.readInt();
    }

    public static final Creator<Apod> CREATOR = new Creator<Apod>() {
        @Override
        public Apod createFromParcel(Parcel in) {
            return new Apod(in);
        }

        @Override
        public Apod[] newArray(int size) {
            return new Apod[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(explanation);
        dest.writeString(hdurl);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(start_date);
        dest.writeString(end_date);
        dest.writeInt(count);
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
