package com.plaintextsam.plainoldnote;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.plaintextsam.plainoldnote.databinding.ActivityMainBinding;
import com.plaintextsam.plainoldnote.model.NoteEntity;
import com.plaintextsam.plainoldnote.utilities.SampleData;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    List<NoteEntity> mNoteEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = activityMainBinding.toolbar;
        setSupportActionBar(toolbar);
        FloatingActionButton fab = activityMainBinding.fab;
        initRecyclerView();
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        mNoteEntities.addAll(SampleData.getNotes());
        for (NoteEntity noteEntity : mNoteEntities) {
            Timber.d(noteEntity.toString());
        }

    }

    private void initRecyclerView() {
        activityMainBinding.included.recyclerView.setHasFixedSize(true);
        activityMainBinding.included.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
