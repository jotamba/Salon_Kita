package com.johanesdaulattamba.salonkita.frontend.fitur.order;

import com.google.gson.annotations.SerializedName;

public class OrderDao {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String nama;

    @SerializedName("fungsi")
    private String fungsi;

    @SerializedName("harga")
    private Double harga;

//    @SerializedName("photo")
//    private String photo;

    public OrderDao(String id, String nama, String fungsi, Double harga) {
        this.id = id;
        this.nama = nama;
        this.fungsi = fungsi;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFungsi() {
        return fungsi;
    }

    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

}
