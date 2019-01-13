package com.intent.fragment.hp.frgmentintant;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements menuBar.listItemClicked {
EditText edtName;
Button btnSubmit,btnInfo;
Intent intent;
int ActivityCodeForForm=1;
FragmentManager manager=this.getSupportFragmentManager();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInfo=findViewById(R.id.btnInfo);
        btnSubmit=findViewById(R.id.btnSubmit);
        edtName=findViewById(R.id.edtName);
        btnInfo.setVisibility(View.GONE);
  manager.beginTransaction().hide(manager.findFragmentById(R.id.iconFragment)).commit();
  btnSubmit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
  intent=new Intent(MainActivity.this,com.intent.fragment.hp.frgmentintant.messageDisplay.class);
  if(edtName.getText().toString().isEmpty()){
      Toast.makeText(MainActivity.this,"plese fill name ",Toast.LENGTH_SHORT).show();
  }
  else
  {
      intent.putExtra("name",edtName.getText().toString().trim());
      startActivity(intent);
  }

      }
  });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,com.intent.fragment.hp.frgmentintant.infoForm.class);
                startActivityForResult(intent,ActivityCodeForForm);

            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ActivityCodeForForm){
            if(requestCode==RESULT_OK)
            {
                manager.beginTransaction().show(manager.findFragmentById(R.id.iconFragment)).commit();
            }
        }
    }
}
