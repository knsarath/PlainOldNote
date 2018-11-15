package com.plaintextsam.plainoldnote.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.plaintextsam.plainoldnote.database.AppRepository;
import com.plaintextsam.plainoldnote.database.NoteEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    AppRepository mAppRepository = AppRepository.getInstance();
    public List<NoteEntity> mNoteEntities;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mNoteEntities = mAppRepository.mNoteEntities;
    }
}
