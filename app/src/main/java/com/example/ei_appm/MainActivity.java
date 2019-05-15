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

        Button btn_ajout = (Button) findViewById(R.id.bajout);
        Button btn_modif = (Button) findViewById(R.id.bmodif);
        Button btn_supp = (Button) findViewById(R.id.bsupp);
        Button btn_affiche = (Button) findViewById(R.id.button4);

        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajout_acti = new Intent(MainActivity.this, ajout.class);
                startActivity(ajout_acti);
            }
        });

        btn_modif.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent afficheActivity = new Intent(MainActivity.this, affiche.class);
            startActivity(afficheActivity);
        } });

        btn_supp.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent afficheActivity = new Intent(MainActivity.this, affiche.class);
            startActivity(afficheActivity);
        } });



        Task task1 = new Task("Exemple de tâche", 3,"15/09/19");

        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        taskBDD.insertTask(task1);

        btn_affiche.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent afficheActivity = new Intent(MainActivity.this, affiche.class);
            startActivity(afficheActivity);
        } });

    }
}
