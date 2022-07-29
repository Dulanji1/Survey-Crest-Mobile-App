package com.example.simplesurveycreator.activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.model.Options;
import com.example.simplesurveycreator.model.Questions;
import com.example.simplesurveycreator.recyclerView.adapter.Model.CallBackListener;
import com.example.simplesurveycreator.recyclerView.adapter.Model.QuestionAdapter;
import com.example.simplesurveycreator.utils.QuestionTypes;
import com.nambimobile.widgets.efab.FabOption;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link surveyCreate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class surveyCreate extends Fragment implements CallBackListener {

    public List<Questions> questionList = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionAdapter mAdapter;
    private ImageView btnPublish;
    private TextView surveyName;

    private FabOption btnMultipleChoice, btnDropDown, btnText, btnFaces, btnRating, btnPoints, btnQuestionBank;

    private List<Options> options = new ArrayList<Options>();

    SharedPreferences sharedpreferences;

    public surveyCreate() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static surveyCreate newInstance() {
        surveyCreate fragment = new surveyCreate();

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
        View rootView = inflater.inflate(R.layout.fragment_survey_create, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_inventory);
        btnMultipleChoice = rootView.findViewById(R.id.btnMultipleChoice);
        btnDropDown = rootView.findViewById(R.id.btnDropDown);
        btnText = rootView.findViewById(R.id.btnText);
        btnFaces = rootView.findViewById(R.id.btnFaces);
        btnRating = rootView.findViewById(R.id.btnRating);
        btnPoints = rootView.findViewById(R.id.btnPoints);
        btnPublish = rootView.findViewById(R.id.btnPublish);
        btnQuestionBank  =  rootView.findViewById(R.id.btnQuestionBank);
        surveyName = rootView.findViewById(R.id.txtSurveyName);

        options.add(new Options("Option 1"));
        options.add(new Options("Option 2"));
        options.add(new Options("Option 3"));
        options.add(new Options("Option 4"));

        mAdapter = new QuestionAdapter(questionList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        LoadCustomerList("Question name", QuestionTypes.MULTI_CHOICE);

        sharedpreferences = getActivity().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        surveyName.setText(sharedpreferences.getString("surveyName", null));

        btnQuestionBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new QuestionBankDialog();
                assert getFragmentManager() != null;
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SurveyPublishFragment()).addToBackStack(null).addToBackStack(null).commit();
            }
        });

        btnMultipleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.MULTI_CHOICE);
            }
        });

        btnDropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.DROPDOWN);
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.TEXT);
            }
        });

        btnFaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.FACES);
            }
        });

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.RATING);
            }
        });

        btnPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadCustomerList("Question name", QuestionTypes.POINTS);
            }
        });


        return rootView;
    }

    @Override
    public void onDismiss() {

    }

    public void LoadCustomerList(String questionName, QuestionTypes type){
        // questionList.clear();
        String timeStamp = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));

        questionList.add(new Questions(timeStamp, questionName, options, type));
        mAdapter.notifyDataSetChanged();
    }
}