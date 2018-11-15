package com.plaintextsam.plainoldnote.utilities;


import com.plaintextsam.plainoldnote.database.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {

    public static final String SAMPLE_TEXT_1 = "A Sample Note";
    public static final String SAMPLE_TEXT_2 = "A note with a\nline feed";
    public static final String SAMPLE_TEXT_3 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    public static Date getDate(int diff) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(Calendar.MILLISECOND, diff);
        return gregorianCalendar.getTime();
    }


    public static List<NoteEntity> getNotes() {
        List<NoteEntity> list = new ArrayList<>();
        list.add(new NoteEntity(1, getDate(0), SAMPLE_TEXT_1));
        list.add(new NoteEntity(2, getDate(-1), SAMPLE_TEXT_2));
        list.add(new NoteEntity(3, getDate(-2), SAMPLE_TEXT_3));
        return list;
    }

}
