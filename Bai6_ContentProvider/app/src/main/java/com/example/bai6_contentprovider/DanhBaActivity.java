package com.example.bai6_contentprovider;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.bai6_contentprovider.model.Contact;

import java.util.ArrayList;

public class DanhBaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSION = 1001;

    ListView lv_DanhBa;
    ArrayList<Contact> ds_DanhBa;
    ArrayAdapter<Contact> adapter_DanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhba);

        themDieuKhien();

        //kiểm tra quyền và yêu cầu quyền nếu chưa được cấp quền truy cập
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_ASK_PERMISSION);
        } else {
            hienThiToanBoLienHe();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ASK_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hienThiToanBoLienHe();
            } else {
                Toast.makeText(this, "Không có quyền truy cập danh bạ!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void themDieuKhien() {
        lv_DanhBa = findViewById(R.id.lvDanhBa);
        ds_DanhBa = new ArrayList<>();
        adapter_DanhBa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ds_DanhBa);
        lv_DanhBa.setAdapter(adapter_DanhBa);
    }

    private void hienThiToanBoLienHe() {
        //Từ ContacsContract.CommonDataKinds.Phone lấy ra danh sách liên hệ trong điện thoại
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        //Trả về 1 cursor - quản lý dữ liệu liên hệ trong máy
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        ds_DanhBa.clear();
        while (cursor.moveToNext()) {
            //Lấy thông tin tên trong danh bạ
            String tenCotTen = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
            //Lấy thong tin SDT trong danh bạ
            String tenCotSDT = ContactsContract.CommonDataKinds.Phone.NUMBER;
            //Lấy vị trí cột trong dữ liệu
            int viTriCotTen = cursor.getColumnIndex(tenCotTen);
            int viTriCotSDT = cursor.getColumnIndex(tenCotSDT);
            //Lấy dữ liệu trong các cột trên ra
            String ten = cursor.getString(viTriCotTen);
            String sdt = cursor.getString(viTriCotSDT);
            //Đưa dữ liệu lấy được vào mảng
            Contact contact = new Contact(ten, sdt);
            ds_DanhBa.add(contact);
            adapter_DanhBa.notifyDataSetChanged();
        }
    }


}
