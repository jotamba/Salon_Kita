package com.johanesdaulattamba.salonkita.frontend.fitur.pembelian;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.johanesdaulattamba.salonkita.R;
import com.johanesdaulattamba.salonkita.frontend.fitur.RecyclerViewAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PembelianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PembelianFragment extends Fragment {

    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    String userId, email;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;

    TextView namaPembeliView, namaBarangView, fungsiView, hargaView;
    Button btn_beli;
    private ProgressDialog progressDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PembelianFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PembelianFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PembelianFragment newInstance(String param1, String param2) {
        PembelianFragment fragment = new PembelianFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pembelian, container, false);
        String namabarang = getArguments().getString(RecyclerViewAdapter.NamaBarang);
        String fungsi = getArguments().getString(RecyclerViewAdapter.Fungsi);
        Double harga = getArguments().getDouble(RecyclerViewAdapter.Harga);

        progressDialog = new ProgressDialog((getContext()));

        namaPembeliView = root.findViewById(R.id.namaPembeliView);
        namaBarangView = root.findViewById(R.id.namaBarangView);
        fungsiView = root.findViewById(R.id.fungsiView);
        hargaView = root.findViewById(R.id.hargaView);

        namaPembeliView.setText(namabarang);
        namaBarangView.setText(namabarang);
        fungsiView.setText(fungsi);
        hargaView.setText("Rp" + harga.toString());

        btn_beli = root.findViewById(R.id.btn_beli);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();
//
//        final DocumentReference documentReference = fStore.collection("users").document(userId);
//        documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                if (documentSnapshot.exists()) {
//                    namaPembeliView.setText(documentSnapshot.getString("fName"));
//                } else {
//                    Log.d("tag", "onEvent: Document do not exists");
//                }
//            }
//        });

        btn_beli.setOnClickListener(new View.OnClickListener() {

//            Navigation.findNavController(view).navigate(R.id.action_nav_beli_to_nav_dashboard);

            @Override
            public void onClick(View view) {

//                long finalPrice = 1 * (harga).longValue();
//                Double d = Long.valueOf(finalPrice).doubleValue();
//
//                fAuth = FirebaseAuth.getInstance();
//                fStore = FirebaseFirestore.getInstance();
//                storageReference = FirebaseStorage.getInstance().getReference();
//                userId = fAuth.getCurrentUser().getUid();
//                user = fAuth.getCurrentUser();
//
//                final DocumentReference documentReference = fStore.collection("users").document(userId);
//                documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                        if (documentSnapshot.exists()) {
//                            email = documentSnapshot.getString("email");
//                            try {
//                                //saveBooking(d, email);
//                            } catch (ParseException parseException) {
//                                parseException.printStackTrace();
//                            }
//                        } else {
//                            Log.d("tag", "onEvent: Document do not exists");
//                        }
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                        builder.setTitle("Thank you for your order")
//                                .setMessage("Please check your transaction history to see detailed data of your transaction")
//                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Navigation.findNavController(view).navigate(R.id.action_nav_beli_to_nav_dashboard);
//                                     }
//                                }).create().show();

//                    }
//                });
//
           }
        });
        return root;
    }


//    private void saveBooking(Double finalPrice, String email) throws ParseException {
//        final String NamaP = namaPembeliView.getText().toString();
//        final String NamaB = namaBarangView.getText().toString();
//        final String Fungsi = fungsiView.getText().toString();
//        final String Harga = hargaView.getText().toString();
//
//        final Double Harga = finalPrice;
//        final String emailUser = email;
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<TransaksiResponse> add = apiService.createBeli(emailUser, NamaP, NamaB, Fungsi, Harga);
//
//
//        add.enqueue(new Callback<TransaksiResponse>() {
//            @Override
//            public void onResponse(Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
//                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onFailure(Call<TransaksiResponse> call, Throwable t) {
//                progressDialog.dismiss();
//
//            }
//        });
//    }

}