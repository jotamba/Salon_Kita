package com.johanesdaulattamba.salonkita.frontend.fitur.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookResponse {
    @SerializedName("data")
    @Expose
    private List<BookDao> booking = null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<BookDao> getBooking() {
        return booking;
    }

    public void setBooking(List<BookDao> booking) {
        this.booking = booking;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
