package com.example.bai5_sharepreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText edtSoThuNhat, edtSoThuHai;
    Button btnTong, btnXoa;
    ListView list_view;
    ArrayList<String> ds_ketqua;
    ArrayAdapter<String> adapter;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



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

        edtSoThuNhat = findViewById(R.id.edt_so_thu_1);
        edtSoThuHai = findViewById(R.id.edt_so_thu_2);
        btnTong = findViewById(R.id.btn_tong);
        btnXoa = findViewById(R.id.btn_xoa);
        list_view = findViewById(R.id.list_View);

        ds_ketqua = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds_ketqua);
        list_view.setAdapter(adapter);


        sharedPreferences = getSharedPreferences("tinhTong", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        loadHistory();

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText
                String soThuNhat = edtSoThuNhat.getText().toString();
                String soThuHai = edtSoThuHai.getText().toString();

                if (!soThuNhat.isEmpty() && !soThuHai.isEmpty()) {
                    int so1 = Integer.parseInt(soThuNhat);
                    int so2 = Integer.parseInt(soThuHai);
                    int tong = so1 + so2;

                    // Thêm kết quả vào danh sách
                    String result = so1 + " + " + so2 + " = " + tong;
                    ds_ketqua.add(result);
                    adapter.notifyDataSetChanged();

                    // Lưu kết quả vào SharePreferences
                    saveHistory(result);

                    // Xóa dữ liệu sau khi tính tổng
                    edtSoThuNhat.setText("");
                    edtSoThuHai.setText("");
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa nội dung của 2 EditText
                edtSoThuNhat.setText("");
                edtSoThuHai.setText("");
            }
        });

    }

    private void saveHistory(String result) {
        ds_ketqua.add(result);
        adapter.notifyDataSetChanged();

        // Lưu toàn bộ danh sách vào SharedPreferences
        editor.putStringSet("history", new HashSet<>(ds_ketqua));
        editor.apply();
    }

    private void loadHistory() {
        Set<String> savedResults = sharedPreferences.getStringSet("history", new HashSet<>());

        ds_ketqua.addAll(savedResults);
        adapter.notifyDataSetChanged();
    }

}