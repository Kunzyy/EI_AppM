package com.example.ei_appm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.taskList);

        Task task1 = new Task("Exemple de tâche", 3,new Date(2019,5,15));

        TaskBDD livreBdd = new TaskBDD(this);
        livreBdd.openForWrite();
        livreBdd.insertTask(task1);

        ArrayList<Task> livreList = livreBdd.getAllTasks();
        livreBdd.close();
        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, livreList);
        list.setAdapter(adapter);

    }
}
