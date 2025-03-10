package com.example.journalapp;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Journal> journalList;

    public MyAdapter(Context context, List<Journal> journalList) {
        this.context = context;
        this.journalList = journalList != null ? journalList : new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.journal_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Journal journal = journalList.get(i);
        myViewHolder.title.setText(journal.getTitle());
        myViewHolder.thoughts.setText(journal.getThoughts());
        String timeAgo = (String) DateUtils.getRelativeTimeSpanString(journal.getTimestamp().getSeconds() * 1000);
        myViewHolder.dateAdded.setText(timeAgo);
        myViewHolder.name.setText(journal.getUserName());
        myViewHolder.userId = journal.getUserId();
        myViewHolder.username = journal.getUserName();

        Glide.with(context)
                .load(journal.getImageUrl())
                .into(myViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, thoughts, dateAdded, name;
        public ImageView image, shareButton;
        public String userId, username;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.journal_title_list);
            thoughts = itemView.findViewById(R.id.journal_thought_list);
            dateAdded = itemView.findViewById(R.id.journal_timestamp_list);
            name = itemView.findViewById(R.id.journal_row_username);
            image = itemView.findViewById(R.id.journal_image_list);
            shareButton = itemView.findViewById(R.id.journal_row_share_button);

            shareButton.setOnClickListener(v -> {
                // TODO: Share journal entry
            });
        }
    }
}
