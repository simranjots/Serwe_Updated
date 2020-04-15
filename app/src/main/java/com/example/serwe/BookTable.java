package com.example.serwe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serwe.Model.Table;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookTable extends AppCompatActivity {

    FirebaseDatabase database;
    TextView noTable;
    String categoryId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        noTable = findViewById(R.id.tablevalue);

        database=FirebaseDatabase.getInstance();
        //get intent
        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");

        if(!categoryId.isEmpty() && categoryId != null){
            Toast.makeText(this,categoryId,Toast.LENGTH_SHORT).show();
        }


        final DatabaseReference tableRef = database.getReference("Table");
        tableRef.child(categoryId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Table table= dataSnapshot.getValue(Table.class);

                noTable.setText(table.getNoTable());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
