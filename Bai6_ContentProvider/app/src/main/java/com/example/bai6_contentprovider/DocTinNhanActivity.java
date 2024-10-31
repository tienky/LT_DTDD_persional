package com.example.bai6_contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.SimpleDateFormat;

import com.example.bai6_contentprovider.adapter.AdapterTinNhan;
import com.example.bai6_contentprovider.model.TinNhan;

import java.util.ArrayList;

public class DocTinNhanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSION = 1001;

    ListView lv_DocTinNhan;
    ArrayList<TinNhan> ds_TinNhan;
    AdapterTinNhan adapter_TinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doc_tin_nhan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        themDieuKhien();
        hienThiToanBoTinNhan();
    }

    private void themDieuKhien() {
        lv_DocTinNhan = findViewById(R.id.lvDocTinNhan);
        ds_TinNhan = new ArrayList<>();
        adapter_TinNhan = new AdapterTinNhan(this, R.layout.item_tinnhan, ds_TinNhan);
        lv_DocTinNhan.setAdapter(adapter_TinNhan);
    }

    private void hienThiToanBoTinNhan() {
        //SimpleDateFormat để định dạng thời gian
        SimpleDateFormat fm = new SimpleDateFormat("HH:mm:ss");
        //Từ ContacsContract.CommonDataKinds.Phone lấy ra danh sách liên hệ trong điện thoại
        Uri uri = Uri.parse("content://sms/inbox");
        //Trả về 1 cursor - quản lý dữ liệu liên hệ trong máy
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        ds_TinNhan.clear();
        while (cursor.moveToNext()) {
            //Lấy vi tri tên cột trong du lieu tin nhắn
            int viTriCotTen = cursor.getColumnIndex("address");
            int viTriCotThoiGian = cursor.getColumnIndex("date");
            int viTriCotBody = cursor.getColumnIndex("body");

            //Lấy dư liệu trong các cot trên
            String sodienthoai = cursor.getString(viTriCotTen);
            String thoigian = cursor.getString(viTriCotThoiGian);
            String body = cursor.getString(viTriCotBody);

            //Đưa vao mảng
            ds_TinNhan.add(new TinNhan(sodienthoai, fm.format(Long.parseLong(thoigian)), body));
            adapter_TinNhan.notifyDataSetChanged();
    }

    }

}