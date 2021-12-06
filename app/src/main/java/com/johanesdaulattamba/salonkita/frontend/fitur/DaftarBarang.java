package com.johanesdaulattamba.salonkita.frontend.fitur;

import java.util.ArrayList;

public class DaftarBarang {
    public ArrayList<Barang> BARANG;

    public DaftarBarang() {
        BARANG = new ArrayList<>();
        BARANG.add(Pomade);
        BARANG.add(Sisir);

    }

    public static final Barang Pomade = new Barang("Pomade Salon Kita", "Stylis Rambut Super", 125000,
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//82/MTA-3005007/king-pomade_king-pomade-super-shine-ukuran-sedang-2-8-oz-aroma-sirsak_full05.jpg");

    public static final Barang Sisir = new Barang("Sisir Tony Start","Menyisir Rambut",1800000,
            "https://images.tokopedia.net/img/cache/500-square/product-1/2020/6/16/batch-upload/batch-upload_dd5bd21e-bdef-483d-b62c-a736bfde9441.jpg.webp?ect=4g");



}
