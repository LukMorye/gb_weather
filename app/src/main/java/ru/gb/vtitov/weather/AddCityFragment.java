package ru.gb.vtitov.weather;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class AddCityFragment extends Fragment  implements View.OnClickListener {

    /* Constants */
    private String TAG = AddCityFragment.class.getSimpleName();
    /* View elements */
    private EditText mCityTextEdit;
    private Button mCancelButton;
    private Button mAcceptButton;

    public AddCityFragment() {
        // Required empty public constructor
    }

    public static AddCityFragment newInstance() {
        AddCityFragment fragment = new AddCityFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVIew(view);
    }

    private void initVIew(View view) {
        mCityTextEdit = view.findViewById(R.id.add_city_edit);
        mCityTextEdit.setOnClickListener(this);
        mAcceptButton = view.findViewById(R.id.add_city_accept);
        mAcceptButton.setOnClickListener(this);
        mCancelButton = view.findViewById(R.id.add_city_cancel);
        mCancelButton.setOnClickListener(this);

    }

    @Override
    public void onPause() {
        super.onPause();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onClick(View view) {
        getActivity().getSupportFragmentManager().popBackStack();
        switch (view.getId()) {
            case R.id.add_city_edit:
            case R.id.add_city_accept:
                onAccept();
                break;
            case R.id.add_city_cancel:
                onCancel();
                break;
            default: throw new RuntimeException("Unknown element");
        }
    }

    private void onAccept() {
        Log.d(TAG,"Add new city to data base");
    }

    private void onCancel() {
        Log.d(TAG,"User just cancel");
    }
}
