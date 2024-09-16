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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_layout);
        TextView txtV_signup=findViewById(R.id.txtView_Signup);
        txtV_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        EditText edt=findViewById(R.id.input_Email);
        Button btn=findViewById(R.id.btn_Login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = "Doan Cao Cuong - 22115053122105";
                edt.setText(inputText);
                Toast.makeText(getApplicationContext(), "Doan Cao Cuong - 22115053122105", Toast.LENGTH_SHORT).show();
            }
        });

    }
}