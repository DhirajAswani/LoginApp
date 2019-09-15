package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView receivedText;
    private Button back;
    int request_ok = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        receivedText  = findViewById(R.id.receivedText);
        back = findViewById(R.id.button);
        Bundle extra = getIntent().getExtras();
//        String name = getIntent().getStringExtra("username");
          String name = extra.getString("username");
        Log.d("Integer", " "+extra.getInt("int"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("message_back" , "from_second_activity");
                setResult(request_ok,intent);
                finish();
            }
        });

        receivedText.setText(name);
    }
}
