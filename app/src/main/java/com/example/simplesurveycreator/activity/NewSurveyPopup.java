package com.example.simplesurveycreator.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.simplesurveycreator.R;

import es.dmoral.toasty.Toasty;

public class NewSurveyPopup extends DialogFragment {

    EditText txtSurveyName;
    TextView btnClose;
    Button btnCancel,btnGetStarted;

    SharedPreferences sharedpreferences;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnClose = (TextView) view.findViewById(R.id.btnClose);
        txtSurveyName = (EditText) view.findViewById(R.id.txtSurveyName);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnGetStarted = (Button) view.findViewById(R.id.btnCreate);

        sharedpreferences = getActivity().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedpreferences.edit();


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtSurveyName.getText().length() <= 0){
                    Toasty.warning(getActivity(), "Please enter survey name", Toast.LENGTH_SHORT, true).show();
                    return;
                }

                editor.putString("surveyName", txtSurveyName.getText().toString());
                editor.commit();

                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new surveyCreate()).addToBackStack(null).commit();
                dismiss();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.popup_new_survey, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View root = inflater.inflate(R.layout.popup_new_survey, null);
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //Customizing the dialog features
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent_blue)));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return dialog;
    }
}
