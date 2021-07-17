package com.core.news;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.core.model.NewDetailItem;
import com.core.model.NewItem;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<NewDetailItem> data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);

        recyclerView = this.findViewById(R.id.news_detail_recycler_view);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        initData(id);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData(int id) {
        data = new ArrayList<>();
        NewDetailItem item = new NewDetailItem();
        item.type = 1;
        switch (id) {
            case 0: {
                item.icon = R.mipmap.news;
                data.add(item);
                break;
            }
            case 1: {
                item.icon = R.mipmap.abc;
                data.add(item);
                break;
            }
            case 2: {
                item.icon = R.mipmap.age;
                data.add(item);
                break;
            }
            case 3: {
                item.icon = R.mipmap.sydney;
                data.add(item);
                break;
            }
        }

        NewDetailItem item1 = new NewDetailItem();
        item1.title = "National";
        item1.icon = R.mipmap.national;
        item1.type = 2;
        data.add(item1);

        NewDetailItem item2 = new NewDetailItem();
        item2.title = "World";
        item2.icon = R.mipmap.world;
        item2.type = 2;
        data.add(item2);

        NewDetailItem item3 = new NewDetailItem();
        item3.title = "Sports";
        item3.icon = R.mipmap.sports;
        item3.type = 2;
        data.add(item3);

        NewDetailItem item4 = new NewDetailItem();
        item4.title = "Health";
        item4.icon = R.mipmap.health;
        item4.type = 2;
        data.add(item4);
        System.out.println(data);

        // create adapter
        NewsDetailAdapter detailAdapter = new NewsDetailAdapter(data);
        recyclerView.setAdapter(detailAdapter);
    }
}
