package com.example.grocerieslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {

    private EditText textNote, textNotice;
    private String note, notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        textNote = findViewById(R.id.editTextGrocery);
        textNotice = findViewById(R.id.editTextNotice);

    }

    public void addNote(View view) {
        note = textNote.getText().toString();
        notice = textNotice.getText().toString();

        Note newNote = new Note(note, notice);
        NoteStorage.getInstance().addNote(newNote);
    }
}