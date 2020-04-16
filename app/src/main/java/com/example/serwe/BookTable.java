package com.example.serwe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serwe.Model.Table;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.zip.Checksum;

public class BookTable extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference tableref;
    TextView noTable;
    String categoryId;
    Button booktable;
    Table table = new Table();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        noTable = findViewById(R.id.tablevalue);
        booktable = findViewById(R.id.booktblbtn);

        database=FirebaseDatabase.getInstance();
        //get intent
        if(getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
            tablecount(categoryId);
        }

      booktable.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int tab = table.getNoTable();
              if (tab > 0) {
                  int  t1 = tab - 1;
                  tableref.child(categoryId).child("noTable").setValue(t1);
              }else {
                  Toast.makeText(getApplicationContext(),"No More Table Available",Toast.LENGTH_SHORT).show();
              }


          }
      });

    }



    void tablecount(String categoryId){

        tableref = database.getReference("Table");
        tableref.child(categoryId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                table = dataSnapshot.getValue(Table.class);
                noTable.setText(String.valueOf(table.getNoTable()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
