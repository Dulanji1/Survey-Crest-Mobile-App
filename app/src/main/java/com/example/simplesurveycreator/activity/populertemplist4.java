package com.example.simplesurveycreator.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplesurveycreator.R;


public class populertemplist4 extends Fragment {
private ImageView btn1;
private TextView btn2;

    public populertemplist4() {
        // Required empty public constructor
    }


    public static populertemplist4 newInstance(String param1, String param2) {
        populertemplist4 fragment = new populertemplist4();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_populertemplist4, container, false);

        btn1 = rootView.findViewById(R.id.custmfeedbtn1);
        btn2 = rootView.findViewById(R.id.custmfeedbtn2);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem1()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem1()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}