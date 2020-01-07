package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed_nickname;
    private String testNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        findViewById(R.id.next).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        ed_nickname = findViewById(R.id.nickname);
        testNickname = ed_nickname.getText().toString();
        if(!TextUtils.isEmpty(testNickname)){
            Log.d("RESULT_NICKNAME", testNickname);
            Intent age = new Intent(this,AgeActivity.class);
            SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
            pref.edit()
                    .putString("nickname",testNickname)
                    .commit();
            startActivityForResult(age,10);
            setResult(RESULT_OK);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("訊息")
                    .setMessage("暱稱欄不可為空白")
                    .setPositiveButton("OK",null)
                    .show();
        }

    }
}
