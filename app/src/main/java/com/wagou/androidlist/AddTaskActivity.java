package com.wagou.androidlist;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    private FloatingActionButton effacerButton;
    private FloatingActionButton annulerButton;
    private FloatingActionButton okButton;
    private EditText libelle;
    private CheckBox statut;
    private RadioGroup priorite;
    private RadioButton degrePriorite;
    private DatePicker date;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        libelle = findViewById(R.id.libelle);
        statut = findViewById(R.id.statut);
        priorite = findViewById(R.id.priorite);
        date = findViewById(R.id.date);

        annulerButton = findViewById(R.id.annulerButton);
        annulerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                effacer();
                finish();
            }
        });

        effacerButton = findViewById(R.id.effacerButton);
        effacerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                effacer();
            }
        });

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                task = new Task();
                task.setLibelle(libelle.getText().toString());
                task.setStatut(statut.isChecked());
                int selectedId = priorite.getCheckedRadioButtonId();
                degrePriorite = findViewById(selectedId);
                task.setPriorite(degrePriorite.getText().toString());
                task.setDate(date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth());
                returnMainActivity();
            }
        });
    }

    public void returnMainActivity() {
        Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
        intent.putExtra("task", task);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void effacer() {
        libelle.setText("");
        statut.setChecked(false);
        priorite.check(R.id.moyenne);
        Calendar c = Calendar.getInstance();
        date.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
    }
}
