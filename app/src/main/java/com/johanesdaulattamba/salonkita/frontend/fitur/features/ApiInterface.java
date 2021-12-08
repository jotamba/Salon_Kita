package com.johanesdaulattamba.salonkita.frontend.fitur.features;

import com.johanesdaulattamba.salonkita.frontend.fitur.book.BookResponse;
import com.johanesdaulattamba.salonkita.frontend.fitur.order.OrderResponse;
import com.johanesdaulattamba.salonkita.frontend.fitur.pembelian.PembelianResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("book")
    Call<BookResponse> getAllBook(@Query("data") String data);


    @POST("book/insert")
    @FormUrlEncoded
    Call<BookResponse> createBook(@Field("email") String email,
                                  @Field("nama") String nama,
                                  @Field("notelp") String notelp,
                                  @Field("jambook") int jambook,
                                  @Field("tanggal") String tanggal);

    @PUT("book/update/{id}")
    @FormUrlEncoded
    Call<BookResponse> updateBook(@Path("id") String id,
                                  @Field("email") String email,
                                  @Field("nama") String nama,
                                  @Field("notelp") String notelp,
                                  @Field("jambook") int jambook,
                                  @Field("tanggal") String tanggal);


    @DELETE("book/delete/{id}")
    Call<BookResponse> deleteBook(@Path("id") String id);
}
