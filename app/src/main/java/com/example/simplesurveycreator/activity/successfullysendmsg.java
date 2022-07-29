package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;


public class successfullysendmsg extends Fragment {
    private Button btn1,btn2;


    public successfullysendmsg() {
        // Required empty public constructor
    }

    public static successfullysendmsg newInstance(String param1, String param2) {
        successfullysendmsg fragment = new successfullysendmsg();

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

        View rootView = inflater.inflate(R.layout.fragment_successfullysendmsg, container, false);

        btn1 = rootView.findViewById(R.id.sendbackbtn);
        btn2 = rootView.findViewById(R.id.sendexitbtn);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new shareoptionslist()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();

            }

        });
        return rootView;
    }
}

