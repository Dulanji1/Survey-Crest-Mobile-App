package com.example.simplesurveycreator.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplesurveycreator.R;


public class reportChartMenue extends Fragment {

    private ImageView btn1,btn3,btn5,btn7,btn9;
    private TextView btn2,btn4,btn6,btn8,btn10;

    public reportChartMenue() {
        // Required empty public constructor
    }



    public static reportChartMenue newInstance(String param1, String param2) {
        reportChartMenue fragment = new reportChartMenue();

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
        View rootView = inflater.inflate(R.layout.fragment_report_chart_menue, container, false);

        btn1 = rootView.findViewById(R.id.barchartbtn1);
        btn2 = rootView.findViewById(R.id.barchartbtn2);

        btn3 = rootView.findViewById(R.id.piechartbtn1);
        btn4 = rootView.findViewById(R.id.piechartbtn2);

        btn5 = rootView.findViewById(R.id.linechartbtn1);
        btn6 = rootView.findViewById(R.id.linechartbtn2);


        btn7 = rootView.findViewById(R.id.columnchartbtn1);
        btn8 = rootView.findViewById(R.id.columnchartbtn2);

        btn9 = rootView.findViewById(R.id.requestnewctbtn1);
        btn10 = rootView.findViewById(R.id.requestnewctbtn2);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Barchart2()).addToBackStack(null).commit();

            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Barchart2()).addToBackStack(null).commit();

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Piechart()).addToBackStack(null).commit();

            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Piechart()).addToBackStack(null).commit();

            }

        });

        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new linechart()).addToBackStack(null).commit();

            }

        });
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new linechart()).addToBackStack(null).commit();

            }

        });


        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new columnchart()).addToBackStack(null).commit();

            }

        });

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new columnchart()).addToBackStack(null).commit();

            }

        });

        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new requestnewchart2()).addToBackStack(null).commit();

            }

        });

        btn10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new requestnewchart2()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}