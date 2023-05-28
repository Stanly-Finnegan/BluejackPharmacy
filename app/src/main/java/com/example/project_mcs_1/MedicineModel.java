package com.example.project_mcs_1;

public class MedicineModel {

    String nama, manufaktur, tipe, harga, detail;
    int gambar;

    public MedicineModel(String nama, String manufaktur, String tipe, String harga, int gambar, String detail) {
        this.nama = nama;
        this.manufaktur = manufaktur;
        this.tipe = tipe;
        this.harga = harga;
        this.gambar = gambar;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getManufaktur() {
        return manufaktur;
    }

    public void setManufaktur(String manufaktur) {
        this.manufaktur = manufaktur;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
