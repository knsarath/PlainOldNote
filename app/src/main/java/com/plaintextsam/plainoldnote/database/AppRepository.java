package com.plaintextsam.plainoldnote.database;

import com.plaintextsam.plainoldnote.utilities.SampleData;

import java.util.List;

public class AppRepository {
    private static final AppRepository ourInstance = new AppRepository();
    public List<NoteEntity> mNoteEntities;


    public static AppRepository getInstance() {
        return ourInstance;
    }
    private AppRepository() {
        mNoteEntities = SampleData.getNotes();
    }


}
