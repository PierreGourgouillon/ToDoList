package com.example.app_todolist.Screens;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
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
import java.util.Observable;
import java.util.Observer;

public class ToDoFragment extends Fragment {

    Button createButton;
    View view;
    List<ViewModel> listToPrint = new ArrayList<ViewModel>();
    ToDoAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_todo, container, false);
        this.createButton = view.findViewById(R.id.create_todo);

        changeView(this.createButton, R.id.action_fragment_todo2_to_fragment_create);

        this.listToPrint = generateList();
        this.adapter = new ToDoAdapter(listToPrint);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        if(getArguments() != null){
            addItem(new ViewModel(getArguments().getParcelable("key")));
        }


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

    private void addItem(ViewModel viewModel){
        listToPrint.add(viewModel);
        adapter.notifyDataSetChanged();
    }

    private List<ViewModel> generateList(){
        List<ViewModel> simpleViewModelList = new ArrayList<>();

        for (int i =0; i < 10; i++){
            ViewModel viewModel = new ViewModel(new ToDo("Salut mec " + i, "Je suis la description", "14:50"));
            viewModel.getToDo().setId(i);
            simpleViewModelList.add(viewModel);
        }

        return simpleViewModelList;
    }


}