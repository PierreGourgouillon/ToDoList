package com.example.app_todolist.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_todolist.Database.Handler;
import com.example.app_todolist.R;
import com.example.app_todolist.Domain.ToDo;

public class ToDoCreate extends Fragment {

    View view;
    ImageView backButton;
    EditText titleInput;
    EditText descriptionInput;
    Button createTask;
    LinearLayout buttonCalendar;
    LinearLayout containerCalendar;
    CalendarView calendar;
    String date;
    TextView textButtonCalendar;

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
        setButtonCalendar();
        readDataCalendar();

        return view;
    }

    private void initialiseComponents(View view){
        this.backButton = view.findViewById(R.id.back_button);
        this.createTask = view.findViewById(R.id.create_task);
        this.titleInput = view.findViewById(R.id.title_new_task);
        this.descriptionInput = view.findViewById(R.id.description_new_task);
        this.calendar = view.findViewById(R.id.calendar);
        this.containerCalendar = view.findViewById(R.id.container_calendar);
        this.buttonCalendar = view.findViewById(R.id.button_calendar);
        this.textButtonCalendar = view.findViewById(R.id.text_button_calendar);
    }

    private void readDataCalendar(){
        this.calendar.setOnDateChangeListener((calendarView, i, i1, i2) -> {
            this.date = i2 + "/" + (i1 + 1) + "/" + i;
            this.textButtonCalendar.setText(date);
            this.containerCalendar.setVisibility(View.GONE);
        });
    }

    private void setButtonCalendar(){
        this.buttonCalendar.setOnClickListener(view -> {
            View viewFragment = view.getRootView();
            viewFragment.findViewById(R.id.container_calendar).setVisibility(View.VISIBLE);
        });
    }

    private void returnToLastFragment(){
        this.backButton.setOnClickListener(view -> Navigation.findNavController(view).popBackStack());
    }

    private void setButtonNewTask(){
        this.createTask.setOnClickListener(view -> {
            try {
                redirectToMainFragment(createNewToDo());
            }catch (NullPointerException e){
                printErrorCompleteAllInput();
            }
        });
    }

    private void printErrorCompleteAllInput(){
        Toast toast = Toast.makeText(getContext(),"Complete all input", Toast.LENGTH_SHORT);
        toast.show();
    }

    private ToDo createNewToDo(){
        return new ToDo(titleInput.getText().toString(), descriptionInput.getText().toString(), "15:5 AM");
    }

    private void redirectToMainFragment(ToDo newTask){
        Handler db = new Handler(getContext());
        db.addNewTask(newTask);
        Navigation.findNavController(view).popBackStack();
    }

}