package com.example.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button go;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView=(TextView)findViewById(R.id.textViewU);
        go=(Button)findViewById(R.id.button2);
        back=(Button)findViewById(R.id.button3);

        final Intent passedIntent=getIntent();
        final String passedUrl=passedIntent.getStringExtra("URL");
        textView.setText(passedUrl);
        //each two buttons override 'onClick'
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (passedUrl.length() != 0) { //open URL address for mobile browser
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));
                    startActivity(intent);
                } else {//if URL address is empty, don't open
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요", Toast.LENGTH_LONG).show();  //show user need retyping for toast
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로가기를 눌렀습니다.",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
