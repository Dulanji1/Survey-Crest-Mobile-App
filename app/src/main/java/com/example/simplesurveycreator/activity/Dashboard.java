package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.recyclerView.adapter.Model.dashboardAdapter;
import com.example.simplesurveycreator.recyclerView.adapter.Model.dashboardModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Dashboard extends Fragment {
    RecyclerView recyclerView;
    dashboardAdapter dashboardAdapter;
    CardView cardView;

    public Dashboard() {
        // Required empty public constructor
    }

    public static Dashboard newInstance(String param1, String param2) {
        Dashboard fragment = new Dashboard();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dashboard);

       // recyclerView = findViewById(R.id.recyclerViewdashboard);
       // recyclerView.setLayoutManager(new LinearLayoutManager);

       // dashboardAdapter = new dashboardAdapter(this, getList());
        //recyclerView.setAdapter(dashboardAdapter);

        Log.d(TAG, "onCreate: started");
        getList();
    }

        private ArrayList<dashboardModel> getList() {
            ArrayList<dashboardModel> models = new ArrayList<>();

            dashboardModel m = new dashboardModel();
            m.setSurveyName("Survey 01");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 01");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 02");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 03");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 04");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 05");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            m = new dashboardModel();
            m.setSurveyName("Survey 06");
            m.setCreatedDate("date : 10.02.2020");
            m.setSubmissions("submissions : 10");
            m.setQuestions("Questions : 10");
            m.setPages("pages : 1");
            models.add(m);

            initRecyclerView();
            return models;
        }
    private  void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: started");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_dashboard, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerViewdashboard);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), LinearLayoutManager.VERTICAL));

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new responses()).commit();

            }


        });
        return rootView;
    }

    }