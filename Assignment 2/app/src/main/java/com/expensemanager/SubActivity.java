package com.expensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

//BUG
//        String type = getIntent().getExtras().getString("type");
//        switch (type){
//            case "Home Rent":
//                imageView.setImageResource(R.drawable.rent);
//                textView.setText("Enter your home rent:");
//                break;
//            case "Eating Out":
//                textView.setText("Enter your eating out:");
//                imageView.setImageResource(R.drawable.eat);
//                break;
//            case "Travel":
//                textView.setText("Enter your shopping expenses:");
//                imageView.setImageResource(R.drawable.travel);
//                break;
//            case "Shopping":
//                textView.setText("Enter your travel expenses:");
//                imageView.setImageResource(R.drawable.shop);
//                break;
//        }

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String value = editText.getText().toString();
                try {
                    double inputVal = Double.parseDouble(value);
                    Intent intent = new Intent();
                    intent.putExtra("result", inputVal);
                    SubActivity.this.setResult(RESULT_OK, intent);
                    SubActivity.this.finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "enter numbers only", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
