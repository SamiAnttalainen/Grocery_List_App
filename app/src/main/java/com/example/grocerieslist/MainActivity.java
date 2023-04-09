package com.example.grocerieslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private NoteStorage noteStorage;
    private RecyclerView recyclerView;
    private ImageView sortByAlphabets, sortByCreation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteStorage = NoteStorage.getInstance();
        Log.d("MainActivity", "Number of notes in storage: " + noteStorage.getNotes().size());
        recyclerView = findViewById(R.id.recyclerViewNoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NoteListAdapter(getApplicationContext(), noteStorage.getNotes()));
        sortByAlphabets = findViewById(R.id.imageViewSortByAlphabet);
        sortByCreation = findViewById(R.id.imageViewSortByDate);

        // Sorts recycler view list alphabetically
        sortByAlphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(noteStorage.getNotes(), new Comparator<Note>() {
                    @Override
                    public int compare(Note note1, Note note2) {
                        return note1.getNote().compareToIgnoreCase(note2.getNote());
                    }
                });
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        sortByCreation.setOnClickListener(view -> {
            Collections.sort(noteStorage.getNotes(), new Comparator<Note>() {
                @Override
                public int compare(Note note, Note t1) {
                    return Long.compare(note.getCreation(), t1.getCreation());
                }
            });
            recyclerView.getAdapter().notifyDataSetChanged();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void switchToAddNoteActivity(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }





}