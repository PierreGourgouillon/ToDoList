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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_todo, container, false);
        this.createButton = view.findViewById(R.id.create_todo);

        changeView(this.createButton, R.id.action_fragment_todo2_to_fragment_create);

        ToDoAdapter adapter = new ToDoAdapter(generateList());
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

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

    private List<ViewModel> generateList(){
        List<ViewModel> simpleViewModelList = new ArrayList<>();

        for (int i =0; i < 200; i++){
            ViewModel viewModel = new ViewModel(new ToDo(i, "Salut mec " + i, "Je suis la description", "14:50"));
            simpleViewModelList.add(viewModel);
        }

        return simpleViewModelList;
    }


}