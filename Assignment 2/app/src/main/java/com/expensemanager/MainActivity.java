package com.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView sum, textView;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        sum = findViewById(R.id.sum);
        textView = findViewById(R.id.textView);

        String[] listItem = getResources().getStringArray(R.array.types);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value = adapter.getItem(position);
                Intent subAct = new Intent(MainActivity.this, SubActivity.class);
                subAct.putExtra("type", value);
                startActivityForResult(subAct, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        double result = data.getExtras().getDouble("result");
        total += result;
        textView.setVisibility(View.VISIBLE);
        sum.setVisibility(View.VISIBLE);
        sum.setText(total + "$");
    }
}
