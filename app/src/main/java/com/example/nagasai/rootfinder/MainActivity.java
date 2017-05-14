package com.example.nagasai.rootfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText et1, et2;
    TextView tvOutput, tvHint;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvHint = (TextView) findViewById(R.id.tvHint);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                et1.setText("");
                et2.setText("");
                tvOutput.setText("");
                tvHint.setText("");
                return true;
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("") && et2.getText().toString().equals("")) {
                    tvOutput.setText(R.string.enter_numbers);
                } else {
                    tvOutput.setText(String.valueOf(Math.pow(Double.parseDouble(et1.getText().toString()), (1 / Double.parseDouble(et2.getText().toString())))));
                }
                tvHint.setText(R.string.clear_values);
            }
        });
    }
}