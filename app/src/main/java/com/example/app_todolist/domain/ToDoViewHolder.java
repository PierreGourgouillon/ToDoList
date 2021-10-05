package com.example.app_todolist.domain;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_todolist.R;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    private final TextView titleTask;
    private final TextView descriptionTask;
    private final TextView hourTask;


    public ToDoViewHolder(final View itemView){
        super(itemView);
        this.titleTask = (TextView) itemView.findViewById(R.id.title_task);
        this.descriptionTask = (TextView) itemView.findViewById((R.id.description_task));
        this.hourTask = (TextView) itemView.findViewById(R.id.hour_task);
    }

    public void bindData(final ViewModel viewModel){
        this.titleTask.setText(viewModel.getToDo().getTitle());
        this.descriptionTask.setText(viewModel.getToDo().getDescription());
        this.hourTask.setText(viewModel.getToDo().getHours());
    }
}
