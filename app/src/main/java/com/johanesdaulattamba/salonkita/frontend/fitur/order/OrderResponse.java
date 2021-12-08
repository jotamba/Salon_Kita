package com.johanesdaulattamba.salonkita.frontend.fitur.order;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderResponse {
    @SerializedName("data")
    @Expose
    private List<OrderResponse> order = null;

    @SerializedName("message")
    @Expose
    private String message;

    public List<OrderResponse> getOrder() {
        return order;
    }

    public void setOrder(List<OrderResponse> order) {
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
