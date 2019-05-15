package com.example.ei_appm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class supprimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);

        Button supp = (Button) findViewById(R.id.bsupp);


        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = findViewById(R.id.et1);
                String nom = et1.getText().toString();
                writeBDD(nom);

                Intent main_acti = new Intent(supprimer.this, MainActivity.class);
                startActivity(main_acti);
            }
        });
    }

    private void writeBDD(String nom)
    {
        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        taskBDD.deleteTask(nom);
        taskBDD.close();
    }
}

