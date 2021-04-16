package com.erpan.latihanuki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ToDo> list = new ArrayList<>();
    ToDoAdapter toDoAdapter;
    DatabaseHelper myDb;
    RecyclerView rvTodo;
    Button btfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);
        list.addAll(myDb.getAllData());
        rvTodo = findViewById(R.id.rvTodo);
        btfab = findViewById(R.id.fab);

        rvTodo.setLayoutManager(new LinearLayoutManager(this));
        toDoAdapter = new ToDoAdapter(MainActivity.this, list);
        toDoAdapter.notifyDataSetChanged();
        rvTodo.setAdapter(toDoAdapter);

        btfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentfab = new Intent(MainActivity.this, AddTodo.class);
                startActivity(intentfab);
            }
        });

    }

}