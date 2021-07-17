package com.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;
import java.util.Arrays;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText txtIn, value1, value2, value3;
    private Button distancesBtn, weightsBtn, tempBtn;
    private TextView label1, label2, label3;

    private UnitConverter u = new UnitConverter();
    private Spinner unitsIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u.setUnitType("distances");
        initializeIds();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsIn.setAdapter(adapter);

        final String[] baths = getResources().getStringArray(R.array.types);


        distancesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setUnitType("distances");
                unitsIn.setSelection(Arrays.asList(baths).indexOf("Metre"));

                Map<String, String> values = convert(txtIn);
               if(values != null){
                   Object[] keys = values.keySet().toArray();

                   label1.setText(keys[0].toString(), TextView.BufferType.EDITABLE);
                   label2.setText(keys[1].toString(), TextView.BufferType.EDITABLE);
                   label3.setText(keys[2].toString(), TextView.BufferType.EDITABLE);

                   value1.setText(values.get(keys[0]), TextView.BufferType.EDITABLE);
                   value2.setText(values.get(keys[1]), TextView.BufferType.EDITABLE);
                   value3.setText(values.get(keys[2]), TextView.BufferType.EDITABLE);
               }
            }
        });

        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setUnitType("temp");
                unitsIn.setSelection(Arrays.asList(baths).indexOf("Celsius"));
                Map<String, String> values = convert(txtIn);

                if(values != null){
                    Object[] keys = values.keySet().toArray();

                    label1.setText(keys[0].toString(), TextView.BufferType.EDITABLE);
                    label2.setText(keys[1].toString(), TextView.BufferType.EDITABLE);
                    label3.setVisibility(View.INVISIBLE);

                    value1.setText(values.get(keys[0]), TextView.BufferType.EDITABLE);
                    value2.setText(values.get(keys[1]), TextView.BufferType.EDITABLE);
                    value3.setVisibility(View.INVISIBLE);
                }
            }
        });

        weightsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setUnitType("weights");
                unitsIn.setSelection(Arrays.asList(baths).indexOf("Kilograms"));
                Map<String, String> values = convert(txtIn);

                if(values != null){
                    Object[] keys = values.keySet().toArray();

                    label1.setText(keys[0].toString(), TextView.BufferType.EDITABLE);
                    label2.setText(keys[1].toString(), TextView.BufferType.EDITABLE);
                    label3.setText(keys[2].toString(), TextView.BufferType.EDITABLE);

                    value1.setText(values.get(keys[0]), TextView.BufferType.EDITABLE);
                    value2.setText(values.get(keys[1]), TextView.BufferType.EDITABLE);
                    value3.setText(values.get(keys[2]), TextView.BufferType.EDITABLE);
                }
            }
        });
    }

    private void initializeIds() {
        unitsIn = findViewById(R.id.spinnerIn);
        txtIn = findViewById(R.id.txtIn);
        distancesBtn = findViewById(R.id.distancesBtn);
        weightsBtn = findViewById(R.id.weightsBtn);
        tempBtn = findViewById(R.id.tempBtn);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);
        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);
        label3 = findViewById(R.id.label3);
    }

    private Map<String, String> convert(EditText txtIn) {
        label1.setVisibility(View.VISIBLE);
        label2.setVisibility(View.VISIBLE);
        label3.setVisibility(View.VISIBLE);

        value1.setVisibility(View.VISIBLE);
        value2.setVisibility(View.VISIBLE);
        value3.setVisibility(View.VISIBLE);

        String input = txtIn.getText().toString();
        try {
            double inputVal = Double.parseDouble(input);
            return u.calculate(inputVal);
        } catch (Exception e) {
            Toast.makeText(this, "enter numbers only", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
