package com.plaintextsam.plainoldnote.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.plaintextsam.plainoldnote.database.AppRepository;
import com.plaintextsam.plainoldnote.database.NoteEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private AppRepository mAppRepository = AppRepository.getInstance(getApplication());
    private LiveData<List<NoteEntity>> mNoteEntities;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mNoteEntities = mAppRepository.getAllNotes();
    }

    public void addSampleData() {
        mAppRepository.addSampleData();
    }

    public LiveData<List<NoteEntity>> getLiveNotesData() {
        return mNoteEntities;
    }

    public void deleteAll() {
        mAppRepository.deleteAll();
    }
}
