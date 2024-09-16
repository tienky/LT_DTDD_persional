package com.example.bai3_constrainlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_layout);
        TextView txtV_haveAnAccount=findViewById(R.id.txtView_haveAnAccount);
        txtV_haveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        EditText edt1=findViewById(R.id.input_UserName);
        EditText edt2=findViewById(R.id.input_Email);
        Button btn=findViewById(R.id.btn_Register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText1 = "Doan Cao Cuong";
                String inputText2 = "22115053122105@sv.ute.udn.vn";
                edt1.setText(inputText1);
                edt2.setText(inputText2);
                Toast.makeText(getApplicationContext(), "Doan Cao Cuong - 22115053122105", Toast.LENGTH_SHORT).show();
            }
        });


    }
}