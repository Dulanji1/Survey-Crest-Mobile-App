package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;


public class Deletemsg extends Fragment {

    private Button btn1,btn2;
    private TextView btn3;

    public Deletemsg() {
        // Required empty public constructor
    }


    public static Deletemsg newInstance(String param1, String param2) {
        Deletemsg fragment = new Deletemsg();

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
        View rootView = inflater.inflate(R.layout.fragment_deletemsg, container, false);

        btn1 = rootView.findViewById(R.id.deletbtn1);
        btn2 = rootView.findViewById(R.id.deletebtn2);
        btn3 = rootView.findViewById(R.id.btnCloses);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new successfullydeletemsg()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem4()).addToBackStack(null).commit();

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem4()).commit();

            }

        });

        return rootView;
    }
}