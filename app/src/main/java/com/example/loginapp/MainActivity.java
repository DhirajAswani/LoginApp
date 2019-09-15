package com.example.loginapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

import static com.example.loginapp.R.*;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
//    private Button Login;
    Button Login;
    private int count = 5;
    private final int request_code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
//        Info.setText("Number Of Attempts Remaining : 5");
        Name = (EditText)findViewById(R.id.editText);
        Password = (EditText)findViewById(R.id.editTextPassword);
        Info = (TextView)findViewById(R.id.tvinfo);
        Login = (Button)findViewById(id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                validate(Name.getText().toString() , Password.getText().toString());
            }
        });



    }

    private void validate(String userName , String userPassword)
    {
        if((userName.equals("admin")) && (userPassword.equals("123")))
        {
            Intent intent = new Intent(MainActivity.this , SecondActivity.class);
            intent.putExtra("username" , userName);
            intent.putExtra("int" , 03);
            startActivityForResult(intent,request_code);
        }
        else
        {
            count--;
            Info.setText("Number Of Attempts Remaining : "+String.valueOf(count));

            if(count == 0)
            {
                Login.setEnabled(false);
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == request_code)
        {
            if(resultCode == 3)
            {
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this , message, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
