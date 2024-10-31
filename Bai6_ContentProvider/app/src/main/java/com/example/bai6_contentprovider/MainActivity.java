package com.example.bai6_contentprovider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSION = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSION = 1002;

    Button btn_DanhBa, btn_TinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        themDieuKhien();
        themSuKien();
    }

    private void themSuKien(){
        btn_DanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDocDanhBa();
            }
        });

        btn_TinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDocTinNhan();
            }
        });
    }

    private void xuLyDocDanhBa() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{"" + "android.permission.READ_CONTACTS"}, REQUEST_SMS_ASK_PERMISSION);
        }
        else{
            Intent intt = new Intent(this, DanhBaActivity.class);
            intt.setClassName("com.example.bai6_contentprovider", "com.example.bai6_contentprovider.DanhBaActivity");
            startActivity(intt);
        }
    }

    private void xuLyDocTinNhan() {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{"" + "android.permission.READ_SMS"}, REQUEST_SMS_ASK_PERMISSION);
        }
        else{
            Intent intt = new Intent(this, DocTinNhanActivity.class);
            intt.setClassName("com.example.bai6_contentprovider", "com.example.bai6_contentprovider.DocTinNhanActivity");
            startActivity(intt);
        }


    }

    private void themDieuKhien() {
        btn_DanhBa = findViewById(R.id.btn_doc_danh_ba_dien_thoai);
        btn_TinNhan = findViewById(R.id.btn_doc_tin_nhan_dien_thoai);

    }


}