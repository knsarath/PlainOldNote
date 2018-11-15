package com.plaintextsam.plainoldnote.model;

import java.util.Date;

public class NoteEntity {
    private int mId;
    private Date mDate;
    private String mText;

    public NoteEntity() {
    }

    public NoteEntity(int id, Date date, String text) {
        mId = id;
        mDate = date;
        mText = text;
    }

    public NoteEntity(Date date, String text) {
        mDate = date;
        mText = text;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }


    @Override
    public String toString() {
        return "NoteEntity{" +
                "mId=" + mId +
                ", mDate=" + mDate +
                ", mText='" + mText + '\'' +
                '}';
    }
}
