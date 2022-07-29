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
import com.example.simplesurveycreator.model.Questions;
import com.example.simplesurveycreator.model.Survey;
import com.example.simplesurveycreator.utils.commonUtils;

import java.util.Date;
import java.util.List;

public class QuestionBankViewHolder extends
        RecyclerView.Adapter<QuestionBankViewHolder.ViewHolder>{

    private List<Questions> questionSet;

    public QuestionBankViewHolder(List<Questions> questions){
        questionSet = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.question_bank_row, parent, false);

        QuestionBankViewHolder.ViewHolder viewHolder = new QuestionBankViewHolder.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Questions question = questionSet.get(position);

        TextView textView = holder.surveyName;
        textView.setText(question.getQuestionName());

    }

    @Override
    public int getItemCount() {
        return questionSet.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView surveyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            surveyName = (TextView) itemView.findViewById(R.id.txtSurveyName);
        }
    }
}
