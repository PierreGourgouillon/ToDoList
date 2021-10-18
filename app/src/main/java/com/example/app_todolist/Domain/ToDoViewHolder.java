package com.example.app_todolist.Domain;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_todolist.R;

//Objectif : Afficher la vue avec les données

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleTask;
    private final TextView descriptionTask;


    public ToDoViewHolder(final View itemView, ClickCallback callback){
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onItemClick(getAdapterPosition());
            }
        });
        this.titleTask = (TextView) itemView.findViewById(R.id.title_task);
        this.descriptionTask = (TextView) itemView.findViewById((R.id.description_task));
    }

    public void bindData(final ViewModel viewModel){
        this.titleTask.setText(viewModel.getToDo().getTitle());
        this.descriptionTask.setText(viewModel.getToDo().getDescription());
    }


}
