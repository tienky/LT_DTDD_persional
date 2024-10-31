package com.example.bai6_contentprovider.model;

import java.io.Serializable;

public class TinNhan implements Serializable {
    private String sodienthoai, thoigian, body;

    public TinNhan(String sodienthoai, String thoigian, String body) {
        this.sodienthoai = sodienthoai;
        this.thoigian = thoigian;
        this.body = body;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
