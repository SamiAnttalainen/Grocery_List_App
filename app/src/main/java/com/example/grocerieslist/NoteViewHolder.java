package com.example.grocerieslist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    TextView holderNote, holderNotice;
    ImageView editImage, removeImage;
    EditText editNote;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        holderNote = itemView.findViewById(R.id.textViewNote);
        holderNotice = itemView.findViewById(R.id.textViewNotice);
        editNote = itemView.findViewById(R.id.editNote);
        editImage = itemView.findViewById(R.id.imageViewEdit);
        removeImage = itemView.findViewById(R.id.imageViewDelete);
    }
}
