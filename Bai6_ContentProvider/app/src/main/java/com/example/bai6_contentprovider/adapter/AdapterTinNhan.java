package com.example.bai6_contentprovider.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bai6_contentprovider.R;
import com.example.bai6_contentprovider.model.TinNhan;

import java.util.List;

public class AdapterTinNhan extends ArrayAdapter<TinNhan> {

    Activity context;
    int resource;
    @NonNull
    List<TinNhan> objects;

    public AdapterTinNhan(@NonNull Activity context, int resource, @NonNull List<TinNhan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View hang = inflater.inflate(this.resource, null);

        TextView _so = hang.findViewById(R.id.txtview_so_dien_thoai);
        TextView _thoigian = hang.findViewById(R.id.txtview_thoi_gian);
        TextView _body = hang.findViewById(R.id.txtview_body);

        _so.setText(this.objects.get(position).getSodienthoai());
        _thoigian.setText(this.objects.get(position).getThoigian());
        _body.setText(this.objects.get(position).getBody());

        return hang;
    }
}
