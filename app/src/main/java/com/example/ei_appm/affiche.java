package com.example.ei_appm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class affiche extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);

        ListView list = (ListView) findViewById(R.id.taskList);
        TextView txt = (TextView) findViewById(R.id.result_sum);

        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        ArrayList<Task> taskList = taskBDD.getAllTasks();
        taskBDD.close();
        System.out.println(taskList);
        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, taskList);
        list.setAdapter(adapter);
    }



    
}
