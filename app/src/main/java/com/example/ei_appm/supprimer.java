package com.example.ei_appm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class supprimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);

        Button supp = (Button) findViewById(R.id.bsupp);

        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = findViewById(R.id.et1).toString();
                TaskBDD taskBDD = new TaskBDD(getParent());
                taskBDD.openForWrite();
                taskBDD.deleteTask(nom);
                taskBDD.close();
            }
        });
    }
}
