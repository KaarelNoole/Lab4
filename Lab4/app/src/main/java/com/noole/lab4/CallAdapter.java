package com.noole.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CallAdapter extends RecyclerView.Adapter<CallViewHolder> {
    private List<String> numbers;
    private LayoutInflater layoutInflater;

    public CallAdapter(Context context,List<String> numbers) {
        this.layoutInflater = layoutInflater.from(context);
        this.numbers = numbers;

    }

    @NonNull
    @Override
    public CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_layout,parent,false);
        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallViewHolder holder, int position) {
        String number = numbers.get(position);
        TextView textView = holder.itemView.findViewById(R.id.txtNumber);
        textView.setText(number);
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }
}
