package com.intent.fragment.hp.frgmentintant;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements menuBar.listItemClicked ,View.OnClickListener{
EditText edtName;
Button btnSubmit,btnInfo;
Intent intent;
int ActivityCodeForForm=1;
    ImageView imgMood,imgCall,imgWeb,imgEmail;
    String iname,iweb,iemail,imob;

FragmentManager manager=this.getSupportFragmentManager();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInfo=findViewById(R.id.btnInfo);
        btnSubmit=findViewById(R.id.btnSubmit);
        edtName=findViewById(R.id.edtName);
        btnInfo.setVisibility(View.GONE);
        imgMood=findViewById(R.id.imgMood);
        imgCall=findViewById(R.id.imgCall);
        imgEmail=findViewById(R.id.imgEmail);
        imgWeb=findViewById(R.id.imgWeb);
        iname="rahul";
        imob="7545995484";
        iweb="https://google.com";
        iemail="rahulrampur974@gmail.com";
        manager.beginTransaction()
                .hide(manager.findFragmentById(R.id.iconFragment))
                .commit();
        btnSubmit.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        imgWeb.setOnClickListener(this);
        imgCall.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
        imgMood.setOnClickListener(this);



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

            if(resultCode==RESULT_OK)
            {
                manager.beginTransaction().show(manager.findFragmentById(R.id.iconFragment)).commit();
                iname=data.getStringExtra("iname");
                iemail=data.getStringExtra("iemail");
                imob=data.getStringExtra("imob");
                iweb=data.getStringExtra("iweb");

            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnInfo){
            intent=new Intent(MainActivity.this,com.intent.fragment.hp.frgmentintant.infoForm.class);
            startActivityForResult(intent,ActivityCodeForForm);
        }
        if(v.getId()==R.id.btnSubmit){
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
        if (v.getId()==R.id.imgCall){
        intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+imob));
            startActivity(intent);

        }
        if (v.getId()==R.id.imgMood){
          Toast.makeText(MainActivity.this,iname,Toast.LENGTH_SHORT).show();
        }
        if (v.getId()==R.id.imgEmail){
            intent =new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+iemail));
            startActivity(intent);
        }
        if (v.getId()==R.id.imgWeb){
            intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+iweb));
            startActivity(intent);

        }


    }
}
