package com.plaintextsam.plainoldnote.database;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {NoteEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "appdb.db";
    private static final Object LOCK = new Object();
    private static volatile AppDataBase sInstance;

    public static AppDataBase getInstance(Application application) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(application, AppDataBase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sInstance;
    }


    public abstract NoteDAO noteDao();
}
