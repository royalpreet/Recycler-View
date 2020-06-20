package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Display extends AppCompatActivity {
    ImageView image;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_layout);
        image = (ImageView)findViewById(R.id.img);
        text = (TextView)findViewById(R.id.txt);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("image");
        String txt = intent.getStringExtra("text");

        text.setText(txt);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
