package com.example.ei_appm;

public class Task {
    private int id;
    private String name;
    private String description;

    public Task() {}

    public Task(String name, String descr) {
        this.name = name;
        this.description = descr;
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
        sb.append("Nom de la tâche = " + name + "\n" + "Description de la tâche = " + description);
        return sb.toString();
    }

}
