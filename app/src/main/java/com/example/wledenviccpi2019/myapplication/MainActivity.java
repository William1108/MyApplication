package com.example.wledenviccpi2019.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.oc.hnapp.android.HNQueryTask;

public class MainActivity extends AppCompatActivity {

    private HNQueryTask _task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HNArticlesAdapter adapter = new HNArticlesAdapter();
        recyclerView.setAdapter(adapter);

        _task = new HNQueryTask(adapter, 80, 1);
        _task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _task.cancel(true);
    }
}
