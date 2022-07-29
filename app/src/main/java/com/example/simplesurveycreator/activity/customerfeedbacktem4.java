package com.example.simplesurveycreator.activity;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.simplesurveycreator.R;


public class customerfeedbacktem4 extends Fragment {
    private Button btn1,btn2,btn3,btn4;



    public customerfeedbacktem4() {
        // Required empty public constructor
    }


    public static customerfeedbacktem4 newInstance(String param1, String param2) {
        customerfeedbacktem4 fragment = new customerfeedbacktem4();

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
        View rootView = inflater.inflate(R.layout.fragment_customerfeedbacktem4, container, false);

        btn1 = rootView.findViewById(R.id.tem4btn1);
        btn2 = rootView.findViewById(R.id.tem4btn2);
        btn3 = rootView.findViewById(R.id.tem4btn3);
        btn4 = rootView.findViewById(R.id.tem4btn4);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new customerfeedbacktem3()).addToBackStack(null).commit();

            }

        });



        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setCancelable(true);
                builder.setTitle("Save Create Survey");
                builder.setMessage("Are you sure save the survey?");

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new prviewsurveylist()).addToBackStack(null).commit();
                    }
                });
                builder.show();
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new shareoptionslist()).addToBackStack(null).commit();

            }

        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setCancelable(true);
                builder.setTitle("Delete Create Survey");
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
                        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new templatemenue()).addToBackStack(null).commit();
                    }
                });
                builder.show();
            }

        });


        return rootView;
    }
}