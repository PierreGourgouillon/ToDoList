package com.example.app_todolist.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.app_todolist.Database.Handler;
import com.example.app_todolist.R;
import com.example.app_todolist.Domain.ToDo;
import com.google.android.material.textfield.TextInputLayout;

public class ToDoCreate extends Fragment {

    View view;
    ImageView backButton;
    EditText titleInput;
    EditText descriptionInput;
    Button createTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_create, container, false);

        initialiseComponents(view);
        returnToLastFragment();
        setButtonNewTask();

        return view;
    }

    private void initialiseComponents(View view){
        this.backButton = view.findViewById(R.id.back_button);
        this.createTask = view.findViewById(R.id.create_task);
        this.titleInput = view.findViewById(R.id.title_new_task);
        this.descriptionInput = view.findViewById(R.id.description_new_task);
    }

    private void returnToLastFragment(){
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).popBackStack();
            }
        });
    }

    private void setButtonNewTask(){
        this.createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    redirectToDoFragment(createNewToDo());
                }catch (NullPointerException e){
                    printCompleteAllInput();
                }
            }
        });
    }

    private void printCompleteAllInput(){
        Toast toast = Toast.makeText(getContext(),"Complete all input", Toast.LENGTH_SHORT);
        toast.show();
    }

    private ToDo createNewToDo(){
        return new ToDo(titleInput.getText().toString(), descriptionInput.getText().toString(), "15:5 AM");
    }

    private void redirectToDoFragment(ToDo newTask){
        Handler db = new Handler(getContext());
        db.addNewTask(newTask);
        Navigation.findNavController(view).popBackStack();
    }

}