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

import com.example.app_todolist.R;
import com.example.app_todolist.domain.ToDo;
import com.example.app_todolist.domain.ToDoAdapter;
import com.example.app_todolist.domain.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ToDoFragment extends Fragment {

    Button createButton;
    View view;
    List<ViewModel> listToPrint;
    ToDoAdapter adapter;

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

        if(getArguments() != null){
            addItem(new ViewModel(getArguments().getParcelable("newTask")));
        }

        return view;
    }

    private void initialiseComponents(){
        this.listToPrint = new ArrayList<ViewModel>();
        this.createButton = view.findViewById(R.id.create_todo);
    }

    private void manageRecyclerView(){
        createRecyclerView();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void createRecyclerView(){
        this.adapter = new ToDoAdapter(listToPrint);
    }

    public void navToNewFragment(Button button, int id){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(id);
            }
        });
    }

    private void addItem(ViewModel viewModel){
        this.listToPrint.add(viewModel);
        adapter.notifyDataSetChanged();
    }


}