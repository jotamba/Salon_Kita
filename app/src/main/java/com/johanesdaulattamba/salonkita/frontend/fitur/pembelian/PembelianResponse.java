package com.johanesdaulattamba.salonkita.frontend.fitur.pembelian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PembelianResponse {
    @SerializedName("data")
    @Expose
    private List<PembelianDao> pembelian = null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<PembelianDao> getTransactions() {
        return pembelian;
    }

    public void setTransactions(List<PembelianDao> transactions) {
        this.pembelian = transactions;
    }
}
