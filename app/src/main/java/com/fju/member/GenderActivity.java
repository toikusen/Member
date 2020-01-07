package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText ed_age;
    private String testAge;
    private EditText ed_gender;
    private String testGender;
    private RadioButton rb_man;
    private RadioButton rb_woman;

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

        RadioButton rb_man = new RadioButton(GenderActivity.this);
        RadioButton rb_woman = new RadioButton(GenderActivity.this);
        RadioGroup rg = (RadioGroup)findViewById(R.id.radiogroup);
        rg.addView(rb_man);
        rg.addView(rb_woman);

        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_man:
                Log.d("RESULT_GENDER", testGender);
                SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
                pref.edit()
                        .putString("gender", "男")
                        .commit();
                setResult(RESULT_OK);
                finish();
                break;
            case R.id.rb_woman:
                Log.d("RESULT_GENDER", testGender);
                SharedPreferences pref2 = getSharedPreferences("test",MODE_PRIVATE);
                pref2.edit()
                        .putString("gender", "女")
                        .commit();
                setResult(RESULT_OK);
                finish();
        }

//        if("man".equals(testGender) || "woman".equals(testGender)){
//            Log.d("RESULT_GENDER", testGender);
//            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
//            pref.edit()
//                    .putString("gender", testGender)
//                    .commit();
//            setResult(RESULT_OK);
//            finish();
//        }else {
//            new AlertDialog.Builder(this)
//                    .setTitle("訊息")
//                    .setMessage("年齡欄須輸入man或woman")
//                    .setPositiveButton("OK",null)
//                    .show();
//        }

    }
}
