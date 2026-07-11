package com.tuusuario.model;

public class Task {
    private int id;
    private String title;
    private String priority;
    private boolean done;

    public Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}