package com.johanesdaulattamba.salonkita.frontend.fitur;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
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
import com.johanesdaulattamba.salonkita.frontend.fitur.book.BookDao;
import com.johanesdaulattamba.salonkita.frontend.fitur.book.BookResponse;
import com.johanesdaulattamba.salonkita.frontend.fitur.features.AddCallBack;
import com.johanesdaulattamba.salonkita.frontend.fitur.features.ApiClient;
import com.johanesdaulattamba.salonkita.frontend.fitur.features.ApiInterface;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {

    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    String userId, email;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;

    private TextInputEditText etName, etPhoneNumber, etTime;
    private AutoCompleteTextView etDate;
    private MaterialButton btnCreate;
    private String status;
    private BookDao book;
    private AddCallBack callback;

    private DatePickerDialog.OnDateSetListener mDateListener;

    private ProgressDialog progressDialog;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
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

        View root = inflater.inflate(R.layout.fragment_book, container, false);

        progressDialog = new ProgressDialog(getContext());

        etDate = root.findViewById(R.id.etDate);
        btnCreate = root.findViewById(R.id.btnCreate);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        getActivity(),
                        android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        mDateListener,
                        year, month, day);
                dialog.getWindow();
                dialog.show();
                dialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                dialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);


            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet:yyyy-mm-dd: " + year + "-" + month + "-" + day);
                DecimalFormat mFormat = new DecimalFormat("00");
                String date2 = mFormat.format(Double.valueOf(year)) + "-" + mFormat.format(Double.valueOf(month)) + "-" + mFormat.format(Double.valueOf(day));
                etDate.setText(date2);
            }
        };

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Integer jam = etTime.getText().length();
                String date1 = etDate.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                //Navigation.findNavController(view).navigate(R.id.action_nav_book_to_nav_dashboard);

//                try {
//                    Date dateIn = sdf.parse(date1);

//                    if (jam == 0) {
//                        Toast.makeText(getActivity(), "Minimum Booking 1 Jam", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                    long finalPrice = jam * 25000;
//                    Double d = Long.valueOf(finalPrice).doubleValue();
                    fAuth = FirebaseAuth.getInstance();
                    fStore = FirebaseFirestore.getInstance();
                    storageReference = FirebaseStorage.getInstance().getReference();
                    userId = fAuth.getCurrentUser().getUid();
                    user = fAuth.getCurrentUser();


//                                        @Override
//                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                Navigation.findNavController(view).navigate(R.id.action_nav_book_to_nav_dashboard);

//                            }
//                        });


//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
            }
        });
        return root;
    }

    private void saveBooking(String email) throws ParseException {
        final String Name = etName.getText().toString();
        final String Notelp = etPhoneNumber.getText().toString();
        final int JamBooking = etTime.getText().length();
        final String Date = etDate.getText().toString();
//        final Double Biaya = finalPrice;
        final String emailUser = email;
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BookResponse> add = apiService.createBook(emailUser, Name, Notelp, JamBooking, Date);


        add.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}