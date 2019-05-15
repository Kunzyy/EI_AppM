package com.example.ei_appm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ajout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);



        Button baj = (Button) findViewById(R.id.bajout);


        baj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et1 = findViewById(R.id.et1);
                EditText et2 = findViewById(R.id.et2);
                EditText et3 = findViewById(R.id.et3);



                String edate = et1.getText().toString();
                int eduree = Integer.parseInt(et2.getText().toString());
                System.out.println("Test : " + eduree);
                String etache = et3.getText().toString();
                Task task1 = new Task(etache, eduree, edate);
                writeBDD(task1);

                Intent main_acti = new Intent(ajout.this, MainActivity.class);
                startActivity(main_acti);
            }
        });
    }

    private void writeBDD(Task task1)
    {
        TaskBDD taskBDD = new TaskBDD(this);
        taskBDD.openForWrite();
        taskBDD.insertTask(task1);
        taskBDD.close();
    }

}
