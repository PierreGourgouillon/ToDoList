package com.example.app_todolist.Screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.app_todolist.Database.Handler;
import com.example.app_todolist.Domain.ClickCallback;
import com.example.app_todolist.Domain.ToDo;
import com.example.app_todolist.R;
import com.example.app_todolist.Domain.ToDoAdapter;
import com.example.app_todolist.Domain.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ToDoFragment extends Fragment {

    ImageButton createButton;
    View view;
    List<ViewModel> listToPrint;
    ToDoAdapter adapter;
    Handler dbHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_todo, container, false);

        initialiseComponents();

        navToNewFragment(this.createButton, R.id.action_fragment_todo2_to_fragment_create);

        manageRecyclerView();

        return view;
    }

    private void initialiseComponents(){
        this.createButton = view.findViewById(R.id.create_todo);
        this.dbHandler = new Handler(getContext());
        this.listToPrint = getTasksInDB();
    }

    private void manageRecyclerView(){
        createRecyclerView();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private List<ViewModel> getTasksInDB(){
        List<ViewModel> viewModelList = new ArrayList<>();
        for(ToDo todo : dbHandler.getToDos()){
            viewModelList.add(new ViewModel(todo));
        }
        return viewModelList;
    }

    private void createRecyclerView(){
        this.adapter = new ToDoAdapter(listToPrint, new ClickCallback() {
            @Override
            public void onItemClick(int position) {
                ViewModel viewModel = listToPrint.get(position);
            }
        });
    }

    public void navToNewFragment(ImageButton button, int id){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(id);
            }
        });
    }

}