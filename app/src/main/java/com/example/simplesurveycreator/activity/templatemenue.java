package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link templatemenue#newInstance} factory method to
 * create an instance of this fragment.
 */
public class templatemenue extends Fragment {

    private ImageView btn1;
    private TextView btn2;


    public templatemenue() {
        // Required empty public constructor
    }


    public static templatemenue newInstance(String param1, String param2) {
        templatemenue fragment = new templatemenue();

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

        View rootView = inflater.inflate(R.layout.fragment_templatemenue, container, false);

        btn1 = rootView.findViewById(R.id.sampleteplistbtn1);
        btn2 = rootView.findViewById(R.id.sampleteplistbtn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new populertemplist4()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new populertemplist4()).addToBackStack(null).commit();
            }

        });
        return rootView;
    }
}

