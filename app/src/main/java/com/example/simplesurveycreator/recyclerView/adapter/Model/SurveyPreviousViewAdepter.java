package com.example.simplesurveycreator.recyclerView.adapter.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplesurveycreator.Consts;
import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.model.Survey;
import com.example.simplesurveycreator.utils.commonUtils;

import java.util.Date;
import java.util.List;


public class SurveyPreviousViewAdepter extends
        RecyclerView.Adapter<SurveyPreviousViewAdepter.ViewHolder>{

    private List<Survey> surveys;

    public SurveyPreviousViewAdepter(List<Survey> surveys) {
        this.surveys = surveys;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.survey_previous_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Survey survey = surveys.get(position);

        TextView textView = holder.surveyName;
        textView.setText(survey.getName());

        holder.lastModifiedDate.setText(commonUtils.dateToStringFormat(new Date(), Consts.dateFormatYYYYMMDD));

    }

    @Override
    public int getItemCount() {
        return surveys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView surveyName, lastModifiedDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            surveyName = (TextView) itemView.findViewById(R.id.txtSurveyName);
            lastModifiedDate = (TextView) itemView.findViewById(R.id.txtLastModifiedDate);
        }
    }

}
