package com.example.ei_appm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            Intent afficheActivity = new Intent(MainActivity.this, modif.class);
            startActivity(afficheActivity);
        } });

        btn_supp.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent afficheActivity = new Intent(MainActivity.this, supprimer.class);
            startActivity(afficheActivity);
        } });


        btn_affiche.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent afficheActivity = new Intent(MainActivity.this, affiche.class);
            startActivity(afficheActivity);
        } });

    }
}
