package com.arjun.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.arjun.notesapp.Model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText edt_title,edt_notes;
    ImageView img_save;
    Notes notes;
    boolean isOldNotes=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);
        edt_notes=findViewById(R.id.edt_notes_txt);
        edt_title=findViewById(R.id.edt_title_txt);
        img_save=findViewById(R.id.image_save);

        if(isOldNotes){
            notes=new Notes();
        }

        try {
            notes = (Notes) getIntent().getSerializableExtra("old_notes");
            edt_title.setText(notes.getTitle());
            edt_title.setText(notes.getNotes());
        }catch ( Exception e){

        }
        img_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=edt_title.getText().toString();
                String description=edt_notes.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "Please Add Some Notes", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter= new SimpleDateFormat("EEE,d MMM YYYY HH:mm a");
                Date date=new Date();

                notes=new Notes();
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent=new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });
    }
}