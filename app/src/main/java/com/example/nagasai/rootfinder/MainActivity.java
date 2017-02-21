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
    static double num, root, e;

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
        e = 0;
        if (!(et1.getText().toString().equals("")) && !(et2.getText().toString().equals(""))) {
            num = Double.parseDouble(et1.getText().toString());
            root = Double.parseDouble(et2.getText().toString());
            if (num == 0) {
                tvOutput.setText("Undefined");
            }
            if (root == 0) {
                tvOutput.setText("0");
            }
            if (num != 0 && root != 0) {
                e = Math.pow(num, 1 / root);
                if ((int) e == e) {
                    tvOutput.setText(String.valueOf((int) e));
                } else
                    tvOutput.setText(String.valueOf(e));
            } else {
                tvOutput.setText("Please enter some values higher then 0");
            }
        } else {
            tvOutput.setText("Please enter numbers");
        }
        tvHint.setText("hold button to reset all values");
    }
}