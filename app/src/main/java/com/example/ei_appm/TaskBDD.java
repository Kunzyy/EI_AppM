package com.example.ei_appm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TaskBDD {
    private static final int VERSION = 1;
    private static final String NOM_BDD = "tasks.db";

    private static final String TABLE_TASKS = "table_tasks";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NAME = "NAME";
    private static final int NUM_COL_NAME = 1;
    private static final String COL_DUREE = "DUREE";
    private static final int NUM_COL_DUREE = 2;
    private static final String COL_DATE = "DATE";
    private static final int NUM_COL_DATE = 3;

    private SQLiteDatabase bdd;
    private TaskSQLite tasks;

    public TaskBDD(Context context) {
        tasks = new TaskSQLite(context, NOM_BDD, null, VERSION);
    }

    public void openForWrite() {
        bdd = tasks.getWritableDatabase();
    }

    public void openForRead() {
        bdd = tasks.getReadableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public long insertTask(Task task) {
        ContentValues content = new ContentValues();
        content.put(COL_NAME, task.getName());

        return bdd.insert(TABLE_TASKS, null, content);
    }

    public int updateTask(int id, Task task) {
        ContentValues content = new ContentValues();
        content.put(COL_NAME, task.getName());

        return bdd.update(TABLE_TASKS, content, COL_ID + " = " + id, null);
    }

    public int removeTask(String name) {
        return bdd.delete(TABLE_TASKS, COL_NAME + " = " + name, null);
    }

    public Task getTask(String name) {
        Cursor c = bdd.query(TABLE_TASKS, new String[] { COL_ID, COL_NAME,
                        COL_DUREE,COL_DATE }, COL_NAME + " LIKE \"" + name + "\"", null, null,
                null, COL_NAME);
        return cursorToTask(c);
    }

    public Task cursorToTask(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        Task task = new Task();
        task.setId(c.getInt(NUM_COL_ID));
        task.setName(c.getString(NUM_COL_NAME));

        c.close();
        return task;
    }

    public ArrayList<Task> getAllTasks() {
        Cursor c = bdd.query(TABLE_TASKS, new String[] { COL_ID, COL_NAME,
                COL_DUREE,COL_DATE }, null, null, null, null, COL_NAME);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<Task> taskList = new ArrayList<> ();
        while (c.moveToNext()) {
            Task task = new Task();
            task.setId(c.getInt(NUM_COL_ID));
            task.setName(c.getString(NUM_COL_NAME));

            taskList.add(task);
        }
        c.close();
        return taskList;
    }

}
