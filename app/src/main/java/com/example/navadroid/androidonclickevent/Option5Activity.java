package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// TODO: View.OnClickListener as inner class
public class Option5Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option5);
        bindView();
        initView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = (EditText) findViewById(R.id.et_input_5);
        tvOutput = (TextView) findViewById(R.id.tv_body_5);
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_process_5).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.button2).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.button).setOnClickListener(new InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_process_5:
                    greet();
                    break;
                case R.id.button2:
                    back();
                    break;
                case R.id.button:
                    next();
                    break;
            }
            hideKeyboardInput(v);
        }
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    private  void back(){
        Intent i1 = new Intent( getApplicationContext(),Option4Activity.class);
        startActivity(i1);
    }

    private void next(){
        Intent i2 = new Intent( getApplicationContext(),Option0Activity.class);
        startActivity(i2);
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}