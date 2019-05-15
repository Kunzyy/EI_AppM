package com.example.ei_appm;

import java.util.Date;

public class Task {

    private String name;
    private int duree;
    private String date;

    public Task() {}

    public Task(String name, int duree, String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
