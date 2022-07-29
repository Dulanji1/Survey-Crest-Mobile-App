package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplesurveycreator.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link populartemlatelist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class populartemlatelist extends Fragment {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();




    public populartemlatelist() {
        // Required empty public constructor
    }


    public static populartemlatelist newInstance(String param1, String param2) {
        populartemlatelist fragment = new populartemlatelist();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("https://www.omniconvert.com/wp-content/uploads/2019/10/new-hero-ab-testing-copy-med.png");
        mNames.add("Customer Feedback");
        mImageUrls.add("https://img.favpng.com/15/19/11/questionnaire-checklist-survey-methodology-png-favpng-80VDM76Z8eENDjLFDBUMX6cEa.jpg");
        mNames.add("Product Survey");
        mImageUrls.add("https://img2.pngio.com/survey-png-5-png-image-survey-png-379_379.png");
        mNames.add("Employee Feedback");
        mImageUrls.add("https://www.clipartkey.com/mpngs/m/158-1580691_feedback-survey-icon-png.png");
        mNames.add("Vaction Travel Template");
        mImageUrls.add("https://www.freeiconspng.com/uploads/survey-icon-12.png");
        mNames.add("Learning Support Template");
        mImageUrls.add("https://www.clipartmax.com/png/middle/421-4213973_analysis-clipart-problem-identification-png-free-survey-icon.png");
        mNames.add("Volunteer Feedback");
        mImageUrls.add("https://s7641.pcdn.co/wp-content/uploads/2020/09/Create-a-Survey.jpg");
        mNames.add("Social Media");
        mImageUrls.add("https://www.questionpro.com/blog/wp-content/uploads/2019/02/Web-Survey.jpg");
        mNames.add("Course evaluation Template");
        mImageUrls.add("https://www.clipartkey.com/mpngs/m/158-1580691_feedback-survey-icon-png.png");
        mNames.add("Happiness Survey");
        mImageUrls.add("https://img.icons8.com/bubbles/2x/survey.png");
        mNames.add("Hobbies");
        mImageUrls.add("https://p.kindpng.com/picc/s/179-1799387_survey-icon-png-circle-png-download-survey-png.png");
        mNames.add("Quarantine Questions");
        mImageUrls.add("https://image.flaticon.com/icons/png/512/1169/1169549.png");
        mNames.add("Remote Work Related Poll");
        mImageUrls.add("https://w7.pngwing.com/pngs/995/238/png-transparent-the-checklist-manifesto-application-form.png");
        mNames.add("Mobile Apps Survey");
        mImageUrls.add("https://w7.pngwing.com/pngs/641/283/png-transparent-computer-icons-web-browser-form-world-wide-web-blue-text-rectangle.png");
        mNames.add("Air Pollution");
        mImageUrls.add("https://img.icons8.com/bubbles/2x/form.png");
        mNames.add("Online Classes Survey");
        mImageUrls.add("https://cdn1.vectorstock.com/i/1000x1000/24/40/modern-flat-icon-with-set-of-folders-documents-vector-8222440.jpg");
        mNames.add("Hotel Guest Feedback");
        initRecyclerView();
    }
    private  void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_populartemlatelist, container, false);


        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
        RecyclerView recyclerView  = (RecyclerView) rootView.findViewById(R.id.recycler_view2);
        ArrayList<String> mNames = new ArrayList<>();
        ArrayList<String> mImageUrls = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(),0));




        return rootView;
    }

    }