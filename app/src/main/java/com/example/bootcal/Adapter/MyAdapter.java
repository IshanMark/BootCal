package com.example.bootcal.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bootcal.Model.Model;
import com.example.bootcal.R;

import java.util.ArrayList;

/**
 * <h3>My Adapter</h3>
 * This is the MyAdapter Class that we use to
 * list to data in Array
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    ArrayList<Model> dataHolder;

    public MyAdapter(ArrayList<Model> dataHolder) {
        this.dataHolder = dataHolder;
    }

    /**
     * set view data in data_view
     */
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.vDate.setText("Date : "+dataHolder.get(position).getDate());
        holder.vEvent.setText("Event : "+dataHolder.get(position).getEvent());
        holder.vNote.setText("Note : "+dataHolder.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    /**
     * getting data in array and set data_view to recycle view
     */
    class myViewHolder extends RecyclerView.ViewHolder{

        TextView vDate, vEvent,vNote;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            vDate = itemView.findViewById(R.id.viewDate);
            vEvent = itemView.findViewById(R.id.viewEvent);
            vNote = itemView.findViewById(R.id.viewNote);
        }
    }
}
