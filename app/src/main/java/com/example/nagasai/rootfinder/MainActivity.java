package com.example.nagasai.rootfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText et1, et2;
    double num = 0, root = 0, e = 0;
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
                et1.setText(null);
                et2.setText(null);
                tvOutput.setText(null);
                tvHint.setText(null);
                return true;
            }
        });
    }

    public void calculate(View view) {
        if (!(et1.getText().toString().equals("")) && !(et2.getText().toString().equals(""))) {
            num = Double.parseDouble(et1.getText().toString());
            root = Double.parseDouble(et2.getText().toString());
            rootFinder(1, num, num, root, 0);
        } else {
            tvHint.setText("hold button to reset all values");
            tvOutput.setText("Please enter numbers");
        }
    }


    public void rootFinder(double low, double high, double num, double root, int counter) {
        if (counter < 7500) {
            counter++;
            double d = (low + high) / 2;
            e = d;
            for (int i = 1; i < root; i++) {
                d *= e;
            }
            if (d == num) {
                output(e);
            } else if (d < num) {
                rootFinder(e, high, num, root, counter);
            } else if (d > num) {
                rootFinder(low, e, num, root, counter);
            }
        } else {
            output(e);
        }
    }

    private void output(double d) {
        tvHint.setText("hold button to reset all values");
        tvOutput.setText(String.valueOf(d));
    }
}