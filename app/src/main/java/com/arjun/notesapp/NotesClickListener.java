package com.arjun.notesapp;

import androidx.cardview.widget.CardView;

import com.arjun.notesapp.Model.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
