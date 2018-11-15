package com.plaintextsam.plainoldnote.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> noteEntity);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("SELECT * FROM tbl_notes WHERE mId = :id")
    NoteEntity getNoteById(int id);

    @Query("SELECT * FROM tbl_notes ORDER BY mDate DESC")
    LiveData<List<NoteEntity>> getAll();

    @Query("DELETE FROM tbl_notes")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM tbl_notes")
    int getCuont();

}
