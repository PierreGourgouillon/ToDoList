package com.example.app_todolist.Screens;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app_todolist.R;

public class ToDoFragment extends Fragment {

    Button createButton;
    Button modifyButton;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_todo, container, false);

        this.createButton = view.findViewById(R.id.create_todo);

        changeView(this.createButton, R.id.action_fragment_todo2_to_fragment_create);

        return view;
    }

    public void changeView(Button button, int id){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(id);
            }
        });
    }
}