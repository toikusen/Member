package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText ed_age;
    private String testAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findViewById(R.id.next).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        ed_age = findViewById(R.id.age);
        testAge = ed_age.getText().toString();
        if(!TextUtils.isEmpty(testAge)){
            Intent gender = new Intent(this,GenderActivity.class);
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("age", testAge)
                    .commit();
            startActivityForResult(gender,10);
            setResult(RESULT_OK);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("訊息")
                    .setMessage("年齡欄不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }

    }
}
