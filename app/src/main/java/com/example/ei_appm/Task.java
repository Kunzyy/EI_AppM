package com.example.ei_appm;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private int duree;
    private Date date;

    public Task() {}

    public Task(int id,String name, int duree, Date date) {
        this.id = id;
        this.name = name;
        this.duree = duree;
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom de la tâche = " + name + "\n" + "Durée de la tâche = " + duree + "\n" + "Date de la tâche = " + date);
        return sb.toString();
    }

}
