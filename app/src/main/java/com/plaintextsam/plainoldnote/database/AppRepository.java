package com.plaintextsam.plainoldnote.database;

import android.content.Context;

import com.plaintextsam.plainoldnote.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import timber.log.Timber;

public class AppRepository {
    private static AppRepository ourInstance;
    public List<NoteEntity> mNoteEntities;
    private AppDataBase mDataBase;
    private Executor mExecutor = Executors.newSingleThreadExecutor();


    private AppRepository(Context context) {
        mDataBase = AppDataBase.getInstance(context);
    }

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    public void addSampleData() {
        mExecutor.execute(() -> {
            Timber.d("Executing addSampleData in %s", Thread.currentThread().getName());
            mDataBase.noteDao().insertAll(SampleData.getNotes());
        });
    }


}
