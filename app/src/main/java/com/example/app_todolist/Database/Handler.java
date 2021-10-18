package com.example.app_todolist.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app_todolist.Domain.ToDo;

import java.util.ArrayList;

public class Handler extends SQLiteOpenHelper {

    private static final String DB_NAME = "ToDoListdb";

    private static final String TABlE_NAME = "Tasks";

    private static final int DB_VERSION = 1;

    private static final String ID_COL = "id";

    private static final String TITLE_COL = "title";

    private static final String DESCRIPTION_COL = "description";

    private static final String ISCOMPLETE_COL = "iscomplete";

    public Handler(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABlE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + ISCOMPLETE_COL + " INTEGER)";
        db.execSQL(query);
    }

    public void addNewTask(ToDo todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TITLE_COL, todo.getTitle().toString());
        values.put(DESCRIPTION_COL, todo.getDescription().toString());
        values.put(ISCOMPLETE_COL, 0);

        db.insert(TABlE_NAME,null, values);
        db.close();
    }

    public ArrayList<ToDo> getToDos(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorToDos = db.rawQuery("SELECT * FROM " + TABlE_NAME, null);

        ArrayList<ToDo> courseModalArrayList = new ArrayList<>();

        if (cursorToDos.moveToFirst()) {
            do {
                courseModalArrayList.add(new ToDo(cursorToDos.getString(1),cursorToDos.getString(2)));
            } while (cursorToDos.moveToNext());
        }

        cursorToDos.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABlE_NAME);
        onCreate(db);
    }
}
