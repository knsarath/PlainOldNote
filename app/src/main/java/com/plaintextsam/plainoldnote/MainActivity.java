package com.plaintextsam.plainoldnote;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.plaintextsam.plainoldnote.database.NoteEntity;
import com.plaintextsam.plainoldnote.databinding.ActivityMainBinding;
import com.plaintextsam.plainoldnote.ui.NotesAdapter;
import com.plaintextsam.plainoldnote.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivitymainbinding;


    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitymainbinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Toolbar toolbar = mActivitymainbinding.toolbar;
        setSupportActionBar(toolbar);
        FloatingActionButton fab = mActivitymainbinding.fab;
        initViewModel();
        initRecyclerView();
        fab.setOnClickListener(this::fabClick);

    }

    private void initViewModel() {
        Observer<List<NoteEntity>> notesObserver = noteEntities -> {
            NotesAdapter notesAdapter = (NotesAdapter) mActivitymainbinding.included.recyclerView.getAdapter();
            if (notesAdapter == null) {
                notesAdapter = new NotesAdapter(noteEntities);
                mActivitymainbinding.included.recyclerView.setAdapter(notesAdapter);
            } else {
                notesAdapter.setData(noteEntities);
            }
        };
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.getLiveNotesData().observe(this, notesObserver);
    }

    private void fabClick(View view) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivity(intent);
    }

    private void initRecyclerView() {
        mActivitymainbinding.included.recyclerView.setHasFixedSize(true);
        mActivitymainbinding.included.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mActivitymainbinding.included.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

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
        if (id == R.id.action_add_data) {
            mMainViewModel.addSampleData();
        } else if (id == R.id.delete_all_notes) {
            mMainViewModel.deleteAll();
        }
        return super.onOptionsItemSelected(item);
    }
}
