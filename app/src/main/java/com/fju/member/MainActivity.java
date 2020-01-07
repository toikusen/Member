package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int RCL = 10;
    private EditText nickname;
    private EditText age;
    private EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nickname = findViewById(R.id.ni);
        age = findViewById(R.id.ag);
        gender = findViewById(R.id.ge);

    }

    public void login (View view){
        Intent intent = new Intent(this,NicknameActivity.class);
        startActivityForResult(intent,RCL);
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
