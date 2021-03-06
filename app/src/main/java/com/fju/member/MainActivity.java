package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int RCL = 10;
    private EditText nickname;
    private EditText age;
    private EditText gender;
    private String resultNickname;
    private String resultAge;
    private String resultGender;
    boolean logon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nickname = findViewById(R.id.ni);
        age = findViewById(R.id.ag);
        gender = findViewById(R.id.ge);
        if (!logon){
            Intent login = new Intent(this, NicknameActivity.class);
            startActivityForResult(login,RCL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        resultNickname = nickname.getText().toString();
        resultAge = age.getText().toString();
        resultGender = gender.getText().toString();
        Log.d("RESULT", resultNickname + "/" + resultAge + "/" + resultGender);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RCL){
            if(resultCode==RESULT_OK){
                nickname.setText(getSharedPreferences("test",MODE_PRIVATE).getString("nickname",""));
                age.setText(getSharedPreferences("test",MODE_PRIVATE).getString("age",""));
                gender.setText(getSharedPreferences("test",MODE_PRIVATE).getString("gender",""));
            }else {
                finish();
            }

        }


    }
}
