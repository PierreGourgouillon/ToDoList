package com.example.app_todolist.domain;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {

    List<ToDo> toDoList;

    public ToDoList(){
        this.toDoList = new ArrayList<ToDo>();
    }

    public void addToList(ToDo todo){
        this.toDoList.add(todo);
    }

    public List<ToDo> getToDoList(){
        return this.toDoList;
    }

    public void removeInList(ToDo toDo){
        this.toDoList.remove(toDo);
    }
}
