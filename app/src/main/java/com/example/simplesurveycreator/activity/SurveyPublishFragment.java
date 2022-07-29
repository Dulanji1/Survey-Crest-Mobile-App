package com.example.simplesurveycreator.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.simplesurveycreator.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurveyPublishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurveyPublishFragment extends Fragment {

    TextInputEditText dateFrom, dateTo;

    final Calendar myCalendar = Calendar.getInstance();

    public SurveyPublishFragment() {
        // Required empty public constructor
    }

    public static SurveyPublishFragment newInstance(String param1, String param2) {
        SurveyPublishFragment fragment = new SurveyPublishFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_survey_publish, container, false);

        dateFrom = rootView.findViewById(R.id.txtDateFrom);
        dateTo = rootView.findViewById(R.id.txtDateTo);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateFrom.setEnabled(true);
        dateFrom.setTextIsSelectable(true);
        dateFrom.setFocusable(false);
        dateFrom.setFocusableInTouchMode(false);
        dateFrom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dateTo.setEnabled(true);
        dateTo.setTextIsSelectable(true);
        dateTo.setFocusable(false);
        dateTo.setFocusableInTouchMode(false);
        dateTo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        return rootView;
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dateFrom.setText(sdf.format(myCalendar.getTime()));
        dateTo.setText(sdf.format(myCalendar.getTime()));
    }
}