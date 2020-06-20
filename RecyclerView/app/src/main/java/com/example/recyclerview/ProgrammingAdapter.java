package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ViewHolder> {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImgUrls = new ArrayList<>();
    private Context mContext;
    private OnNoteListener monNoteListener;

    public ProgrammingAdapter(Context context, ArrayList<String> names, ArrayList<String> imgUrls, OnNoteListener onNoteListener){
        this.mNames = names;
        this.mImgUrls = imgUrls;
        mContext = context;
        this.monNoteListener = onNoteListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view, monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.text.setText(mNames.get(position));
        Log.i("oye", String.valueOf(mNames.size()));
        try {
            Glide.with(mContext)
                    .asBitmap()
                    .load(mImgUrls.get(position))
                    .into(holder.image);
        }catch (Exception e){
            e.printStackTrace();
        }
        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, Display.class);
                i.putExtra("image",mImgUrls.get(position));
                i.putExtra("text",mNames.get(position));
                mContext.startActivity(i);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView text;
        LinearLayout parentLayout;
        OnNoteListener onNoteListener;
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            text = (TextView)itemView.findViewById(R.id.text);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.parentLayout);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
