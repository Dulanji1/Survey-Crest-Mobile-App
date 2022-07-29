package com.example.simplesurveycreator.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.model.Survey;
import com.example.simplesurveycreator.recyclerView.adapter.Model.SurveyPreviousViewAdepter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainScreen extends Fragment {

    private RecyclerView recyclerViewInventory;

    private Button btn1,btn2;

    private Button btnNewSurvey;


    public MainScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static MainScreen newInstance(String param1, String param2) {
        MainScreen fragment = new MainScreen();

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
        View rootView = inflater.inflate(R.layout.fragment_main_screen, container, false);

        btn1 = (Button)rootView.findViewById(R.id.chosetembtn);
        btn2 = (Button)rootView.findViewById(R.id.reportbtn);
        btnNewSurvey = (Button) rootView.findViewById(R.id.btnBlank) ;

        recyclerViewInventory = (RecyclerView) rootView.findViewById(R.id.recycler_view_inventory);



        ArrayList<Survey> surveys = Survey.createSurveyList(10);

        SurveyPreviousViewAdepter adepter = new SurveyPreviousViewAdepter(surveys);
        recyclerViewInventory.setAdapter(adepter);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerViewInventory.setLayoutManager(mLayoutManager);
        recyclerViewInventory.setItemAnimator(new DefaultItemAnimator());
        recyclerViewInventory.addItemDecoration(new DividerItemDecoration(container.getContext(), 0));


        btnNewSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                View popupView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_new_survey, null);
//                final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//
//                popupWindow.showAsDropDown(popupView, 0, 0);

                DialogFragment newFragment = new NewSurveyPopup();
                assert getFragmentManager() != null;
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });


        templatemenue templatemenue = new templatemenue();

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

       getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, templatemenue).addToBackStack(null).commit();



            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new reportHome()).addToBackStack(null).commit();

            }

        });

        return rootView;
    }
}