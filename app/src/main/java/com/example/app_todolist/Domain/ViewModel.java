package com.example.app_todolist.Domain;

//Objectif : Stock les données

public class ViewModel {
    private ToDo toDo;

    public ViewModel(ToDo toDo){
        setToDoList(toDo);
    }

    public void setToDoList(ToDo toDo) {
        this.toDo = toDo;
    }

    public ToDo getToDo() {
        return toDo;
    }
}
