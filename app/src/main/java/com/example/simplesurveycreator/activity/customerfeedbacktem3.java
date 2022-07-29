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
 * Use the {@link customerfeedbacktem3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class customerfeedbacktem3 extends Fragment {
    private Button btn1,btn2;


    public customerfeedbacktem3() {
        // Required empty public constructor
    }

    public static customerfeedbacktem3 newInstance(String param1, String param2) {
        customerfeedbacktem3 fragment = new customerfeedbacktem3();

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
        View rootView = inflater.inflate(R.layout.fragment_customerfeedbacktem3, container, false);

        btn1 = rootView.findViewById(R.id.tepcus3bt1);
        btn2 = rootView.findViewById(R.id.custemb2);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem2()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem4()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}