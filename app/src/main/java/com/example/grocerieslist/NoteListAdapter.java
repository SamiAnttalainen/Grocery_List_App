package com.example.grocerieslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private Context context;
    private ArrayList<Note> notes = new ArrayList<>();

    public NoteListAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.notes_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        holder.holderNote.setText(notes.get(position).getNote());
        holder.holderNotice.setText(notes.get(position).getNotice());
        holder.editNote.setText(notes.get(position).getNote());

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            NoteStorage.getInstance().removeNote(pos);
            notifyItemRemoved(pos);
        });

        holder.editImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.editNote.getVisibility() == View.VISIBLE) {
                Note note = NoteStorage.getInstance().getNoteClass(pos);
                note.setNote(holder.editNote.getText().toString());
                holder.editNote.setVisibility(View.GONE);
                notifyDataSetChanged();
            }
            else {
                holder.editNote.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
