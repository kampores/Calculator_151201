package com.example.calculator_151201;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 유상 on 2015-11-28.
 */
public class CalculatorActivity extends Activity implements View.OnClickListener {
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_0;
    private Button button_Dot;
    private Button button_Answer;
    private Button button_Clear;
    private Button button_Divide;
    private Button button_Multiply;
    private Button button_Minus;
    private Button button_Plus;

    private TextView result;

    private double buffer_Number;
    private String buffer_Operator;
    private boolean new_Input;
    private boolean new_Dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buffer_Number = 0;
        buffer_Operator = " ";
        new_Input = true;
        new_Dot = true;

        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_0 = (Button) findViewById(R.id.button_0);
        button_Dot = (Button) findViewById(R.id.button_Dot);
//        button_Answer = (Button) findViewById(R.id.button_Answer);
        button_Clear = (Button) findViewById(R.id.button_Clear);
        button_Divide = (Button) findViewById(R.id.button_Divide);
        button_Multiply = (Button) findViewById(R.id.button_Multiply);
        button_Minus = (Button) findViewById(R.id.button_Minus);
        button_Plus = (Button) findViewById(R.id.button_Plus);
        result = (TextView) findViewById(R.id.text_Result);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_Dot.setOnClickListener(this);
//        button_Answer.setOnClickListener(this);
        button_Clear.setOnClickListener(this);
        button_Divide.setOnClickListener(this);
        button_Multiply.setOnClickListener(this);
        button_Minus.setOnClickListener(this);
        button_Plus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if( v.equals(button_1)) setText("1");
        if( v.equals(button_2)) setText("2");
        if( v.equals(button_3)) setText("3");
        if( v.equals(button_4)) setText("4");
        if( v.equals(button_5)) setText("5");
        if( v.equals(button_6)) setText("6");
        if( v.equals(button_7)) setText("7");
        if( v.equals(button_8)) setText("8");
        if( v.equals(button_9)) setText("9");
        if( v.equals(button_0)) setText("0");
        if( v.equals(button_Dot))
            if (new_Dot) {
                new_Dot = false;
                setText(".");
            }
        if( v.equals(button_Answer)) calculate("=");
        if( v.equals(button_Divide)) calculate("/");
        if( v.equals(button_Multiply)) calculate("*");
        if( v.equals(button_Minus)) calculate("-");
        if( v.equals(button_Plus)) calculate("+");
        if( v.equals(button_Clear)) calculate("C");

    }

    private void setText(String s) {
//        Log.d("uos.ai.test", "here");
        if(new_Input){
            new_Input = false;
            result.setText(s);
        }
        else {
            result.setText(result.getText()+s);
        }
    }

    private void calculate(String current_Operator) {
        Double current_Number;

        new_Dot = true;
        current_Number = Double.parseDouble(result.getText().toString());
        if ("C".equals(current_Operator)) {
            buffer_Number = 0;
            buffer_Operator = " ";
            new_Input = true;
            result.setText("0");
        }
        else{
            if (" ".equals(buffer_Operator)) {
                buffer_Number = current_Number;
                buffer_Operator = current_Operator;
                new_Input = true;
            }
            else{
                if (new_Input) {
                    buffer_Number = current_Number;
                    buffer_Operator = current_Operator;
                }
                else {
                    new_Input = true;
                    if ("/".equals(buffer_Operator)) buffer_Number = buffer_Number / current_Number;
                    if ("*".equals(buffer_Operator)) buffer_Number = buffer_Number * current_Number;
                    if ("-".equals(buffer_Operator)) buffer_Number = buffer_Number - current_Number;
                    if ("+".equals(buffer_Operator)) buffer_Number = buffer_Number + current_Number;
                    result.setText(String.valueOf(buffer_Number));
                    if ("=".equals(current_Operator)) {
                        buffer_Operator = " ";
                    }
                    else{
                        buffer_Operator = current_Operator;
                    }
                }
            }
        }
    }
}
