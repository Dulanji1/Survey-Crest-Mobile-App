package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;


public class shareoptionslist extends Fragment {
    private ImageView btn1;
    private TextView btn2;

    public shareoptionslist() {
        // Required empty public constructor
    }


    public static shareoptionslist newInstance(String param1, String param2) {
        shareoptionslist fragment = new shareoptionslist();

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
        View rootView = inflater.inflate(R.layout.fragment_shareoptionslist, container, false);

        btn1 = rootView.findViewById(R.id.moreoptimg);
        btn2 = rootView.findViewById(R.id.moreooptbtn);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Shareoptionmorelist()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Shareoptionmorelist()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}