package com.intent.fragment.hp.frgmentintant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class infoForm extends AppCompatActivity {
EditText edtName,edtMob,edtEmail,edtWeb;
Button btnSubmitInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_form);
        edtEmail=findViewById(R.id.edtEmail);
        edtMob=findViewById(R.id.edtMob);
        edtName=findViewById(R.id.edtNameInput);
        edtWeb=findViewById(R.id.edtWeb);
        btnSubmitInput=findViewById(R.id.btnSubmitInput);
        btnSubmitInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if(edtName.getText().toString().isEmpty()||edtWeb.getText().toString().isEmpty()||edtEmail.getText().toString().isEmpty()||edtMob.getText().toString().isEmpty()){
                    Toast.makeText(infoForm.this,"fill all field",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    intent.putExtra("iname",edtName.getText().toString().trim());
                    intent.putExtra("imob",edtMob.getText().toString().trim());
                    intent.putExtra("iemail",edtEmail.getText().toString().trim());
                    intent.putExtra("iweb",edtWeb.getText().toString().trim());
                    setResult(RESULT_OK,intent);
                    infoForm.this.finish();
                }


            }
        });
    }
}
