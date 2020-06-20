package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProgrammingAdapter.OnNoteListener {
    RecyclerView recyclerView;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> imgUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        setTitle("Recycler View");

        /*String[] names = {"ef","wef","egae","aef","arfewa","awfaw","wefqw","ga","wefw","wewg","my",
                "ef","wef","egae","aef","arfewa","awfaw","wefqw","ga","wefw","wewg","my",
                "ef","wef","egae","aef","arfewa","awfaw","wefqw","ga","wefw","wewg","my",
                "ef","wef","egae","aef","arfewa","awfaw","wefqw","ga","wefw","wewg","my"};*/
        names.add("jnwufwkhiehdshvs");names.add("wdjic");names.add("jn");names.add("wdjic");names.add("jn");names.add("wdjic");
        names.add("jn");names.add("wdjic");names.add("jn");names.add("wdjic");names.add("jn");names.add("wdjic");
        imgUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hbx060116masterclass01-1550601705.jpg");
        imgUrls.add("https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-1.2.1&w=1000&q=80");
        imgUrls.add("https://upload.wikimedia.org/wikipedia/commons/3/35/Neckertal_20150527-6384.jpg");
        imgUrls.add("https://i.ytimg.com/vi/c7oV1T2j5mc/maxresdefault.jpg");
        imgUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hbx060116masterclass01-1550601705.jpg");
        imgUrls.add("https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-1.2.1&w=1000&q=80");
        imgUrls.add("https://upload.wikimedia.org/wikipedia/commons/3/35/Neckertal_20150527-6384.jpg");
        imgUrls.add("https://i.ytimg.com/vi/c7oV1T2j5mc/maxresdefault.jpg");
        imgUrls.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/hbx060116masterclass01-1550601705.jpg");
        imgUrls.add("https://images.unsplash.com/photo-1506744038136-46273834b3fb?ixlib=rb-1.2.1&w=1000&q=80");
        imgUrls.add("https://upload.wikimedia.org/wikipedia/commons/3/35/Neckertal_20150527-6384.jpg");
        imgUrls.add("https://i.ytimg.com/vi/c7oV1T2j5mc/maxresdefault.jpg");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProgrammingAdapter(MainActivity.this, names, imgUrls, this));

    }

    @Override
    public void onNoteClick(int position) {
        Toast.makeText(this ,names.get(position), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this , Display.class);
        i.putExtra("image",imgUrls.get(position));
        i.putExtra("text",names.get(position));
        startActivity(i);
    }
}

