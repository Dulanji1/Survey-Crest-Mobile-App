package com.example.simplesurveycreator.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.simplesurveycreator.R;


public class reportHome extends Fragment {

    private Button btn1, btn2;

    public reportHome() {
        // Required empty public constructor
    }


    public static reportHome newInstance(String param1, String param2) {
        reportHome fragment = new reportHome();

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
        View rootView = inflater.inflate(R.layout.fragment_report_home, container, false);

        btn1 = rootView.findViewById(R.id.reportanylzbtn);
        btn2 = rootView.findViewById(R.id.responsanalyzbtn);



        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new reportChartMenue()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new responses()).addToBackStack(null).commit();

            }

        });



        return rootView;
    }
}