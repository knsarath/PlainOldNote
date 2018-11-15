package com.plaintextsam.plainoldnote.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {NoteEntity.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "appdb.db";
    private static final Object LOCK = new Object();
    private static volatile AppDataBase sInstance;

    public static AppDataBase getInstance(Context applicationContext) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(applicationContext, AppDataBase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }


    public abstract NoteDAO noteDao();
}
