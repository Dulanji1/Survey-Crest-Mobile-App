package com.example.simplesurveycreator.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplesurveycreator.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link successfulysaved#newInstance} factory method to
 * create an instance of this fragment.
 */
public class successfulysaved extends Fragment {


    public successfulysaved() {
        // Required empty public constructor
    }

    public static successfulysaved newInstance(String param1, String param2) {
        successfulysaved fragment = new successfulysaved();

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
        return inflater.inflate(R.layout.fragment_successfulysaved, container, false);


    }




}