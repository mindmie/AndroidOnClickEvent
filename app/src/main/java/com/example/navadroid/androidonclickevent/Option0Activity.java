package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// TODO: XML onClick attribute & View object
public class Option0Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;
    private Button btnProcess;
    private Button btnB;
    private Button btnN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // เปรียบเสมือน main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option0);
        bindView();
    }

    // To bind views to this activity
    private void bindView(){ // ผูกฟังก์ชั่นให้ทำงานด้วยกัน
        etInput = (EditText) findViewById(R.id.et_input_0);  // view ที่มีอยู่ใน xml
        tvOutput = (TextView) findViewById(R.id.tv_body_0);
        btnProcess = (Button) findViewById(R.id.btn_process_0);
        btnB = (Button) findViewById(R.id.button2);
        btnN = (Button) findViewById(R.id.button);
    }

    // This "process" method MUST be bound in the layout XML file, "android:onClick="process""
    public void process(View v) {
        // Do we really need to compare view objects?
        if (v == btnProcess) {
            greet();
        }
        else if ( v == btnB){
            back();
        }
        else if (v == btnN){
            next();

        }
        hideKeyboardInput(v);
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    private void back(){
        Intent i = new Intent(getApplicationContext(), Option5Activity.class);
        startActivity(i);
    }

    private void next(){
        Intent i = new Intent(getApplicationContext(), Option1Activity.class);
        startActivity(i);
    }

    // To hide Android soft keyboard วิธีซ่อนคีย์บอร์ด
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
