package com.example.nagasai.rootfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText et1, et2;
    double e = 0, d = 0;
    TextView tvOutput, tvHint;
    Button btnCalculate;
    static int counter = 0;
    static double num, root;
    boolean addI;

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
    }

    public void calculate(View view) {
        counter = 0;
        if (!(et1.getText().toString().equals("")) && !(et2.getText().toString().equals(""))) {
            num = Double.parseDouble(et1.getText().toString());
            root = Double.parseDouble(et2.getText().toString());
            if (num == 0) {
                setOutput(0.0);
            } else if (root == 0) {
                tvOutput.setText("Undefined");
            } else if (num < 0) {
                addI = true;
                rootFinder(1, -num);
            } else {
                rootFinder(1, num);
            }
        } else {
            tvOutput.setText("Please enter numbers");
        }
        tvHint.setText("hold button to reset all values");
    }

    public void rootFinder(double low, double high) {
        if (counter++ < 3000) {
            e = d = (low + high) / 2;
            for (int i = 1; i < root; ++i) {
                d *= e;
            }
            if (d > num) {
                rootFinder(low, e);
            } else if (d < num) {
                rootFinder(e, high);
            } else {
                setOutput(e);
            }
        } else {
            setOutput(e);
        }
    }

    private void setOutput(double e) {
        if ((int) e == e) {
            tvOutput.setText(String.valueOf((int) e));
        } else
            tvOutput.setText(String.valueOf(e));
        if (addI) {
            tvOutput.setText(tvOutput.getText().toString() + "i");
        }
    }
}