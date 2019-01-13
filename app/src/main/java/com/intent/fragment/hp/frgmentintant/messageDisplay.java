package com.intent.fragment.hp.frgmentintant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class messageDisplay extends AppCompatActivity {
TextView tvMsg;
Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_display);
        btnOk=findViewById(R.id.btnBack);
        tvMsg=findViewById(R.id.tvMsg);
        String msg=getIntent().getStringExtra("name").toString();
        msg=msg+" welcome to  message  activity";
        tvMsg.setText(msg);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageDisplay.this.finish();
            }
        });
    }
}
