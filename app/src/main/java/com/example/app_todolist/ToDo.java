package com.example.app_todolist;

public class ToDo {
    private int id;
    private String title;
    private String description;
    private String hours;
    private boolean isCheck;

    public ToDo(int id, String title, String description, String hours){
        this.id = id;
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.isCheck = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getHours() {
        return hours;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
