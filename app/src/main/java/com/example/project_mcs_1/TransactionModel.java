package com.example.project_mcs_1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TransactionModel implements Parcelable {
    String nama, manuf, qty, harga, tanggal;

    int gambar;



    public TransactionModel(String nama, String manuf, String qty, int gambar, String harga, String tanggal) {
        this.nama = nama;
        this.manuf = manuf;
        this.qty = qty;
        this.gambar = gambar;
        this.harga = harga;
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    protected TransactionModel(Parcel in) {
        nama = in.readString();
        manuf = in.readString();
        qty = in.readString();
        gambar = in.readInt();
        harga = in.readString();
    }

    public static final Creator<TransactionModel> CREATOR = new Creator<TransactionModel>() {
        @Override
        public TransactionModel createFromParcel(Parcel in) {
            return new TransactionModel(in);
        }

        @Override
        public TransactionModel[] newArray(int size) {
            return new TransactionModel[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getManuf() {
        return manuf;
    }

    public void setManuf(String manuf) {
        this.manuf = manuf;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(manuf);
        dest.writeString(qty);
        dest.writeInt(gambar);
        dest.writeString(harga);
    }
}
