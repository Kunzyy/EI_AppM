package com.example.ei_appm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bajout = (Button) findViewById(R.id.bajout);

        bajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajout_acti = new Intent(MainActivity.this, ajout.class);
                startActivity(ajout_acti);
            }
        });

     /*   ListView list = (ListView) findViewById(R.id.taskList);

        Task task1 = new Task(42,"Exemple de tâche", 3,new Date(2019,5,15));

        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        taskBDD.insertTask(task1);

        ArrayList<Task> taskList = taskBDD.getAllTasks();
        taskBDD.close();
        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, taskList);
        list.setAdapter(adapter);*/

    }
}
