package com.johanesdaulattamba.salonkita.frontend.fitur;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.johanesdaulattamba.salonkita.BR;
import com.johanesdaulattamba.salonkita.R;
import com.johanesdaulattamba.salonkita.databinding.AdapterRecyclerViewBinding;

import java.util.List;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<Barang> result;
    public static final String NamaBarang="Nama Barang tidak ada";
    public static final String Harga="Harga tidak ada";
    public static final String Fungsi="Fungsi tidak ditemukan";
    public static final Double harga2=0.0;


    public RecyclerViewAdapter(){}

    public RecyclerViewAdapter(Context context, List<Barang> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterRecyclerViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_recycler_view,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Barang daftarBarang = result.get(position);
        holder.bind(daftarBarang);

        String namabarang = holder.adapterRecyclerViewBinding.tvNamaBarang.getText().toString();
        String harga = holder.adapterRecyclerViewBinding.tvHarga.getText().toString();
        String fungsi = holder.adapterRecyclerViewBinding.tvFungsi.getText().toString();
        Double harga2 = Double.parseDouble(harga);


        holder.adapterRecyclerViewBinding.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(NamaBarang,namabarang);
                bundle.putString(Fungsi,fungsi);
                bundle.putDouble(Harga,harga2);

                Navigation.findNavController(view).navigate(R.id.action_nav_order_to_nav_beli,bundle);



            }
        });
    }





    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public AdapterRecyclerViewBinding adapterRecyclerViewBinding;
        public MyViewHolder(AdapterRecyclerViewBinding adapterRecyclerViewBinding)
        {
            super(adapterRecyclerViewBinding.getRoot());
            this.adapterRecyclerViewBinding = adapterRecyclerViewBinding;
        }

        public void bind(Object obj){
            adapterRecyclerViewBinding.setVariable(BR.brg, obj);
            adapterRecyclerViewBinding.executePendingBindings();
        }


    }


}