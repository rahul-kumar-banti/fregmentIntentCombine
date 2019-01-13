package com.intent.fragment.hp.frgmentintant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements menuBar.listItemClicked {
EditText edtName;
Button btnSubmit,btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInfo=findViewById(R.id.btnInfo);
        btnSubmit=findViewById(R.id.btnSubmit);
        edtName=findViewById(R.id.edtName);
        btnInfo.setVisibility(View.GONE);
    }

    @Override
    public void onlistclicked(int i) {
        if(i==0){
            btnInfo.setVisibility(View.GONE);
            btnSubmit.setVisibility(View.VISIBLE);
            edtName.setVisibility(View.VISIBLE);
        }
        else if(i==1){
            btnInfo.setVisibility(View.VISIBLE);
            btnSubmit.setVisibility(View.GONE);
            edtName.setVisibility(View.GONE);
        }
        else
        {

        }
    }
}
