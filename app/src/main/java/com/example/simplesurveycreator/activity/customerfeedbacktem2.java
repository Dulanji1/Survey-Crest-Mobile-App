package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link customerfeedbacktem2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class customerfeedbacktem2 extends Fragment {
    private Button btn1,btn2;


    public customerfeedbacktem2() {
        // Required empty public constructor
    }

    public static customerfeedbacktem2 newInstance(String param1, String param2) {
        customerfeedbacktem2 fragment = new customerfeedbacktem2();

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
        View rootView = inflater.inflate(R.layout.fragment_customerfeedbacktem2, container, false);

        btn1 = rootView.findViewById(R.id.tep2prebtn);
        btn2 = rootView.findViewById(R.id.temp3bckbtn);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem1()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem3()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}