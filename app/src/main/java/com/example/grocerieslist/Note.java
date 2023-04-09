package com.example.grocerieslist;

public class Note {

    public String note, notice;
    public long creation;

    public Note(String note, String notice) {
        this.note = note;
        this.notice = notice;
        this.creation = System.currentTimeMillis();
    }

    public long getCreation() {
        return creation;
    }

    public String getNote() {
        return note;
    }

    public String getNotice() {
        return notice;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
