package com.example.app_todolist.Domain;


public class ToDo {
    private int id;
    private String title;
    private String description;
    private String hours;
    private boolean isComplete;

    public ToDo(String title, String description, String hours){
        verifyData(title,description, hours);
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.isComplete = false;
    }

    private void verifyData(String title, String description, String hours){
        if (title.equals("") || description.equals("") || hours.equals("")){
            throw new NullPointerException();
        }
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

    public void setId(int id) {
        this.id = id;
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
                ", hours='" + hours + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
