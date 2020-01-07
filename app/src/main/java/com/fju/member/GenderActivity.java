package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText ed_age;
    private String testAge;
    private EditText ed_gender;
    private String testGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findViewById(R.id.next).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ed_gender = findViewById(R.id.gender);
        testGender = ed_gender.getText().toString();
        if("man".equals(testGender) || "woman".equals(testGender)){
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("gender", testGender)
                    .commit();
            setResult(RESULT_OK);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("訊息")
                    .setMessage("年齡欄須輸入man或woman")
                    .setPositiveButton("OK",null)
                    .show();
        }

    }
}
