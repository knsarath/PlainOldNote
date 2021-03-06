package com.plaintextsam.plainoldnote;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.plaintextsam.plainoldnote.database.AppDataBase;
import com.plaintextsam.plainoldnote.database.NoteDAO;
import com.plaintextsam.plainoldnote.database.NoteEntity;
import com.plaintextsam.plainoldnote.utilities.SampleData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import timber.log.Timber;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private static final String TAG = "Junit4";

    private AppDataBase mAppDataBase;
    private NoteDAO mNoteDAO;

    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        mAppDataBase = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).build();
        mNoteDAO = mAppDataBase.noteDao();
        Log.i(TAG, "setUp: Done");
    }

    @After
    public void tearDown() throws Exception {
        mAppDataBase.close();
        Log.i(TAG, "tearDown: Db closed");
    }

    @Test
    public void createAndRetreiveNotes() {
        mNoteDAO.insertAll(SampleData.getNotes());
        int count = mNoteDAO.getCuont();
        Log.i(TAG, "Count : " + count);
        Assert.assertEquals(SampleData.getNotes().size(), count);
    }


    @Test
    public void compareStrings() {
        mNoteDAO.insertAll(SampleData.getNotes());
        NoteEntity noteEntity = SampleData.getNotes().get(0);
        NoteEntity fromDb = mNoteDAO.getNoteById(1);
        Assert.assertEquals(noteEntity.getText(), fromDb.getText());
    }

    @Test
    public void compareId() {
        mNoteDAO.insertAll(SampleData.getNotes());
        NoteEntity fromDb = mNoteDAO.getNoteById(1);
        Assert.assertEquals(1, fromDb.getId());
    }

}