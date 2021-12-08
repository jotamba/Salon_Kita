package com.johanesdaulattamba.salonkita.frontend.fitur.pembelian;

import com.google.gson.annotations.SerializedName;

public class PembelianDao {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("fungsi")
    private String fungsi;

    @SerializedName("email")
    private String email;

    @SerializedName("harga")
    private Double harga;

    public PembelianDao (String id, String name, String fungsi, String email, Double harga) {
        this.id = id;
        this.name = name;
        this.fungsi = fungsi;
        this.email = email;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFungsi() {
        return fungsi;
    }

    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
}
