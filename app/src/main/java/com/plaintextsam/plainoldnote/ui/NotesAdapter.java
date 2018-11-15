package com.plaintextsam.plainoldnote.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.plaintextsam.plainoldnote.R;
import com.plaintextsam.plainoldnote.database.NoteEntity;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<NoteEntity> mNoteEntities;

    public NotesAdapter(List<NoteEntity> noteEntities) {
        mNoteEntities = noteEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(layoutInflater.inflate(R.layout.note_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NoteEntity noteEntity = mNoteEntities.get(position);
        viewHolder.mTextView.setText(noteEntity.getText());

    }

    @Override
    public int getItemCount() {
        return mNoteEntities == null ? 0 : mNoteEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
}
