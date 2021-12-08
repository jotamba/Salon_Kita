package com.johanesdaulattamba.salonkita.frontend.fitur.book;

import com.google.gson.annotations.SerializedName;

public class BookDao {
    @SerializedName("id")
    private String id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("notelp")
    private String notelp;

    @SerializedName("jambook")
    private String jambook;

    @SerializedName("tanggal")
    private String tanggal;


    public BookDao(String id, String nama, String notelp, String jambook, String tanggal) {
        this.id = id;
        this.nama = nama;
        this.notelp = notelp;
        this.jambook = jambook;
        this.tanggal = tanggal;
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

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getJambook() {
        return jambook;
    }

    public void setJambook(String jambook) {
        this.jambook = jambook;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
