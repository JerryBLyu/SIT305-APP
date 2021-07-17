package com.core.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.core.model.NewItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<NewItem> data;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();

        initListener();
    }

    /**
     * init user data
     */
    private void initData() {
        data = new ArrayList<>();
        NewItem item = new NewItem();
        item.title = "9 News";
        item.icon = R.mipmap.news;
        data.add(item);

        NewItem item1 = new NewItem();
        item1.title = "ABC News";
        item1.icon = R.mipmap.abc;
        data.add(item1);

        NewItem item2 = new NewItem();
        item2.title = "The Age";
        item2.icon = R.mipmap.age;
        data.add(item2);

        NewItem item3 = new NewItem();
        item3.title = "Sydney Morning Herald";
        item3.icon = R.mipmap.sydney;
        data.add(item3);

        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    /**
     * add item listener
     */
    private void initListener() {
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}
