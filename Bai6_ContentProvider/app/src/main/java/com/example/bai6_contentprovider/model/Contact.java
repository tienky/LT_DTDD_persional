package com.example.bai6_contentprovider.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private String ten;
    private String sodienthoai;

    public Contact(String ten, String sodienthoai) {
        this.ten = ten;
        this.sodienthoai = sodienthoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    @Override
    public String toString() {
        return "Tên: " + this.ten + "\nSố điện thoại: " + this.sodienthoai;
    }
}
