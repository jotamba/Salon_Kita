package com.johanesdaulattamba.salonkita.frontend.fitur;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Barang {

    public String namabarang;
    public String fungsi;
    public Integer harga;
    public String imgURL;

    public Barang(String namabarang, String fungsi, Integer harga, String imgURL) {
        this.namabarang = namabarang;
        this.fungsi = fungsi;
        this.harga = harga;
        this.imgURL = imgURL;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getFungsi() {
        return fungsi;
    }

    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imgURL){
        Glide.with(imageView)
                .load(imgURL)
                .into(imageView);
    }

}
