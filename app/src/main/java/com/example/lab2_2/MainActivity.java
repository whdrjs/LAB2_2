package com.example.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url=(EditText) findViewById(R.id.editText1);
        next=(Button) findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myurl = url.getText().toString();
                Intent intent = new Intent (getApplicationContext(), NewActivity.class);    //set intent, ready to send
                //put address of URL
                intent.putExtra("URL",myurl);
                startActivity(intent);
            }
        });

    }
}
