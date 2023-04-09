package com.example.grocerieslist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class NoteStorage {

    ArrayList<Note> notes = new ArrayList<>();

    private static NoteStorage noteStorage = null;

    private NoteStorage() {
    }

    public static NoteStorage getInstance() {
        if (noteStorage == null) {
            noteStorage = new NoteStorage();
        }
        return noteStorage;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void removeNote(int position) {
        notes.remove(position);
    }

    public Note getNoteClass(int position) {
        return notes.get(position);
    }

}
