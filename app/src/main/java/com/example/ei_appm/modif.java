package com.example.ei_appm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class modif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);

        Button bmodif = (Button) findViewById(R.id.btn2modif);

        bmodif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edate =  findViewById(R.id.et3).toString();
                int eduree =  Integer.parseInt(findViewById(R.id.et2).toString());
                String etache =  findViewById(R.id.et1).toString();
                Task task1 = new Task(etache, eduree,edate);
                writeBDD(task1);

                Intent main_acti = new Intent(modif.this, MainActivity.class);
                startActivity(main_acti);
            }
        });

    }

    private void writeBDD(Task task1)
    {
        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        taskBDD.updateTask(task1);
        taskBDD.close();
    }
}
