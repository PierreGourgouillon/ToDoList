package com.example.app_todolist.domain;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_todolist.R;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTask;

    public ToDoViewHolder(final View itemView){
        super(itemView);
        this.titleTask = (TextView) itemView.findViewById(R.id.title_task);
    }

    public void bindData(final ViewModel viewModel){
        this.titleTask.setText(viewModel.getToDo().getTitle());
    }
}
