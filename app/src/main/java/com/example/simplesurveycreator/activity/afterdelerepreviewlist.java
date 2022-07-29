package com.example.simplesurveycreator.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplesurveycreator.R;

public class afterdelerepreviewlist extends Fragment {



    public afterdelerepreviewlist() {
        // Required empty public constructor
    }

    public static afterdelerepreviewlist newInstance(String param1, String param2) {
        afterdelerepreviewlist fragment = new afterdelerepreviewlist();

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
        return inflater.inflate(R.layout.fragment_afterdelerepreviewlist, container, false);
    }
}