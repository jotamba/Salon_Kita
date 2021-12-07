package com.johanesdaulattamba.salonkita.frontend.fitur.pembelian;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.johanesdaulattamba.salonkita.R;
import com.johanesdaulattamba.salonkita.frontend.fitur.RecyclerViewAdapter;

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

        btn_beli.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_beli_to_nav_dashboard);
           }
        });
        return root;
    }
}