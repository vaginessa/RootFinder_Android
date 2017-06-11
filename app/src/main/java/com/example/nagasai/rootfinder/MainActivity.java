package com.example.nagasai.rootfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText etNumber, etRoot;
    TextView tvOutput, tvHint;
    Button btnCalculate;
    double num, root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = (EditText) findViewById(R.id.etNumber);
        etRoot = (EditText) findViewById(R.id.etRoot);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        tvHint = (TextView) findViewById(R.id.tvHint);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                etNumber.setText("");
                etRoot.setText("");
                tvOutput.setText("");
                tvHint.setText("");
                return true;
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNumber.getText().toString().equals("") && etRoot.getText().toString().equals("")) {
                    tvOutput.setText(R.string.enter_numbers);
                } else if (etRoot.getText().toString().equals(0)) {
                    tvOutput.setText(String.valueOf(1));
                } else {
                    num = Double.parseDouble(etNumber.getText().toString());
                    root = Double.parseDouble(etRoot.getText().toString());
                    rootFinder(0, num);
                }
                tvHint.setText(R.string.clear_values);
            }
        });
    }

    void rootFinder(double start, double end) {
        double number, trailNum, result = (start + end) / 2;
        for (int i = 0; i < 65536; i++) {
            result = (start + end) / 2;
            number = (start + end) / 2;
            trailNum = Math.pow(number, root);
            if (trailNum == num) {
                result = number;
                break;
            } else if (trailNum < num) {
                start = (start + end) / 2;
            } else if (trailNum > num) {
                end = (start + end) / 2;
            }
        }
        tvOutput.setText(String.valueOf(result));
    }
}