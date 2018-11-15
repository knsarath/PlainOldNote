package com.plaintextsam.plainoldnote.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.plaintextsam.plainoldnote.database.NoteEntity;
import com.plaintextsam.plainoldnote.utilities.SampleData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public List<NoteEntity> mNoteEntities = SampleData.getNotes();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
