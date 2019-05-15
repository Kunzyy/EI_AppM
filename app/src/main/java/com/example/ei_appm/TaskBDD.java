package com.example.ei_appm;

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

    public void insertTask(Task task) {
        String request = "INSERT INTO " + TABLE_TASKS + " ( " + COL_NAME + "," + COL_DUREE+ "," + COL_DATE + ") VALUES ( '" + task.getName() + "','" + task.getDuree()+ "','" + task.getDate() + "')";
        bdd.execSQL(request);
    }

    public void updateTask(Task task) {
        String request = "UPDATE " + TABLE_TASKS + " SET " + COL_DUREE + " = " + task.getDuree() + COL_DATE + " = " + task.getDate() + " WHERE " + COL_NAME + " = " + task.getName() ;
        bdd.execSQL(request);
    }

    public void deleteTask(String name) {
        String request = "DELETE FROM " + TABLE_TASKS + " WHERE " + COL_NAME +" = " +name+";";
        System.out.println(request);
        bdd.execSQL(request);
    }

    public int updateTask(int id, Task task) {
        ContentValues content = new ContentValues();
        content.put(COL_NAME, task.getName());

        return bdd.update(TABLE_TASKS, content, COL_ID + " = " + id, null);
    }

    public int removeTask(String name) {
        return bdd.delete(TABLE_TASKS, COL_NAME + " = " + name, null);
    }


    public ArrayList<Task> getAllTasks() {

        String request = "SELECT * FROM " + TABLE_TASKS;

        Cursor c = bdd.rawQuery(request,null);

        c.moveToFirst();


        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        System.out.println("Coucou");
        ArrayList<Task> taskList = new ArrayList<> ();
        while (c.moveToNext()) {
            Task task = new Task();
            task.setName(c.getString(c.getColumnIndex(COL_NAME)));
            task.setDuree(c.getInt(c.getColumnIndex(COL_DUREE)));
            task.setDate(c.getString(c.getColumnIndex(COL_DATE)));
            taskList.add(task);
        }
        c.close();
        return taskList;
    }

}
