package com.wagou.androidlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskArrayAdapter adapter;
    static final int ADD_TASK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskList = new ArrayList<>();

        ListView toDoListView = findViewById(R.id.toDoListView);
        adapter = new TaskArrayAdapter(MainActivity.this, R.layout.list_view_item, taskList);
        toDoListView.setAdapter(adapter);

        FloatingActionButton addTaskButton = findViewById(R.id.fab);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTaskActivity();
            }
        });
    }

    public void openAddTaskActivity() {
        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
        startActivityForResult(intent, ADD_TASK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==ADD_TASK_REQUEST) {
            if(resultCode== Activity.RESULT_OK) {
                Task result = data.getParcelableExtra("task");
                taskList.add(result);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
