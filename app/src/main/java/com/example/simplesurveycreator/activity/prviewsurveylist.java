package com.example.simplesurveycreator.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.simplesurveycreator.R;


public class prviewsurveylist extends Fragment {

    private ImageView btn1,btn2,btn3;

    public prviewsurveylist() {
        // Required empty public constructor
    }


    public static prviewsurveylist newInstance(String param1, String param2) {
        prviewsurveylist fragment = new prviewsurveylist();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_prviewsurveylist, container, false);

        btn1 = rootView.findViewById(R.id.previewlist_edit_btn);
        btn2 = rootView.findViewById(R.id.deletebtn_priew);
        btn3 = rootView.findViewById(R.id.viewchatsbtn);



        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem1()).addToBackStack(null).commit();

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new reportHome()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setCancelable(true);
                builder.setTitle("Delete Record");
                builder.setMessage("Are you sure delete the survey?");

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new afterdelerepreviewlist()).addToBackStack(null).commit();
                    }
                });
                builder.show();
            }

        });

        return rootView;
    }
}