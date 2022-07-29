package com.example.simplesurveycreator.recyclerView.adapter.Model;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.media.tv.TvView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplesurveycreator.R;
import com.example.simplesurveycreator.model.Options;
import com.example.simplesurveycreator.model.Questions;
import com.example.simplesurveycreator.utils.QuestionTypes;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import io.apptik.widget.multiselectspinner.MultiSelectSpinner;

public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Questions> questionList;
    private Context context;
    private Application application;

    private List<Options> options = new ArrayList<Options>();
    String[] ITEMS = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
    ArrayAdapter<String> adapterDDL;

    public QuestionAdapter (List<Questions> _customerList,Context _context) {
        questionList = _customerList;
        context = _context;

        options.add(new Options("Option 1"));
        options.add(new Options("Option 2"));
        options.add(new Options("Option 3"));
        options.add(new Options("Option 4"));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == QuestionTypes.MULTI_CHOICE.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_drop_down, parent, false);
            return new MultiChoiceHolder(view);
        }else if(viewType == QuestionTypes.DROPDOWN.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_spinner, parent, false);
            return new DropDownViewHolder(view);
        }else if(viewType == QuestionTypes.TEXT.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_text, parent, false);
            return new TextViewHolder(view);
        }else if(viewType == QuestionTypes.FACES.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_face, parent, false);
            return new FaceViewHolder(view);
        }else if(viewType == QuestionTypes.RATING.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_rating, parent, false);
            return new RatingViewHolder(view);
        }
        else if(viewType == QuestionTypes.POINTS.ordinal()){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_points, parent, false);
            return new PointsViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_type_drop_down, parent, false);
            return new MultiChoiceHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == QuestionTypes.MULTI_CHOICE.ordinal()){
            InitLayoutMultiChoice((MultiChoiceHolder)holder, position);
        }else if(holder.getItemViewType() == QuestionTypes.DROPDOWN.ordinal()){
            InitLayoutDropDown((DropDownViewHolder)holder, position);
        }else if(holder.getItemViewType() == QuestionTypes.TEXT.ordinal()){
            InitLayoutText((TextViewHolder)holder, position);
        }else if(holder.getItemViewType() == QuestionTypes.FACES.ordinal()){
            InitLayoutFace((FaceViewHolder)holder, position);
        }else if(holder.getItemViewType() == QuestionTypes.RATING.ordinal()){
            InitLayoutRating((RatingViewHolder)holder, position);
        }else if(holder.getItemViewType() == QuestionTypes.POINTS.ordinal()){
            InitLayoutPoints((PointsViewHolder) holder, position);
        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(questionList.get(position).getType() == QuestionTypes.MULTI_CHOICE){
            return QuestionTypes.MULTI_CHOICE.ordinal();
        }else if(questionList.get(position).getType() == QuestionTypes.DROPDOWN){
            return QuestionTypes.DROPDOWN.ordinal();
        }else if(questionList.get(position).getType() == QuestionTypes.TEXT){
            return QuestionTypes.TEXT.ordinal();
        }else if(questionList.get(position).getType() == QuestionTypes.FACES){
            return QuestionTypes.FACES.ordinal();
        }else if(questionList.get(position).getType() == QuestionTypes.RATING){
            return QuestionTypes.RATING.ordinal();
        }else if(questionList.get(position).getType() == QuestionTypes.POINTS){
            return QuestionTypes.POINTS.ordinal();
        }
        return -1;
    }

    private void InitLayoutMultiChoice(MultiChoiceHolder holder, int pos) {
          Questions customers = questionList.get(pos);
            holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
            holder.editTxtQuestion.setText(customers.getQuestionName());

            holder.editTxtQuestion.setVisibility(View.INVISIBLE);
            holder.layoutOptions.setVisibility(View.GONE);
    }

    private void InitLayoutDropDown(DropDownViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
        holder.layoutOptions.setVisibility(View.GONE);
    }

    private void InitLayoutText(TextViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
        holder.layoutOptions.setVisibility(View.GONE);
    }

    private void InitLayoutFace(FaceViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
    }

    private void InitLayoutRating(RatingViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
    }

    private void InitLayoutPoints(PointsViewHolder holder, int pos) {
        Questions customers = questionList.get(pos);
        holder.viewTxtQuestion.setText(customers.getQuestionName());
        holder.viewTxtQuestion.setTag(customers.getTimeStamp());
        holder.editTxtQuestion.setText(customers.getQuestionName());

        holder.editTxtQuestion.setVisibility(View.INVISIBLE);
    }

    // Static inner class to initialize the views of rows
    public class MultiChoiceHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public ConstraintLayout layoutOptionsView;
        public LinearLayout layoutOptions;

        private RecyclerView recyclerView;
        private OptionAdaptor mAdapter;

        public MultiChoiceHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);
            layoutOptionsView = (ConstraintLayout) itemView.findViewById(R.id.layoutOptionsView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_options);

            mAdapter = new OptionAdaptor(options, context.getApplicationContext());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(context.getApplicationContext(), LinearLayoutManager.VERTICAL));
            recyclerView.setAdapter(mAdapter);

            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    layoutOptions.setVisibility(View.VISIBLE);
                    layoutOptionsView.setVisibility(View.INVISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                layoutOptions.setVisibility(View.GONE);
                layoutOptionsView.setVisibility(View.VISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class DropDownViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public ConstraintLayout layoutOptionsView;
        public LinearLayout layoutOptions;

        private RecyclerView recyclerView;
        private OptionAdaptor mAdapter;

        public DropDownViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);
            layoutOptionsView = (ConstraintLayout) itemView.findViewById(R.id.layoutOptionsView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_options);

            mAdapter = new OptionAdaptor(options, context.getApplicationContext());
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context.getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(context.getApplicationContext(), LinearLayoutManager.VERTICAL));
            recyclerView.setAdapter(mAdapter);

            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    layoutOptions.setVisibility(View.VISIBLE);
                    layoutOptionsView.setVisibility(View.INVISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                layoutOptions.setVisibility(View.GONE);
                layoutOptionsView.setVisibility(View.VISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class TextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public ConstraintLayout layoutOptionsView;
        public LinearLayout layoutOptions;

        public TextViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);
            layoutOptionsView = (ConstraintLayout) itemView.findViewById(R.id.layoutOptionsView);


            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    layoutOptions.setVisibility(View.VISIBLE);
                    layoutOptionsView.setVisibility(View.INVISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                layoutOptions.setVisibility(View.GONE);
                layoutOptionsView.setVisibility(View.VISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }



        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class FaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public LinearLayout layoutOptions;

        public FaceViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);


            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }



        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class RatingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public LinearLayout layoutOptions;

        public RatingViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);


            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }



        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public class PointsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        public TextView viewTxtQuestion;
        public EditText editTxtQuestion;
        public ImageButton btnEdit, btnDelete;
        public LinearLayout layoutOptions;

        public PointsViewHolder(View itemView) {
            super(itemView);
            viewTxtQuestion = (TextView) itemView.findViewById(R.id.lblQuestion);
            editTxtQuestion = (EditText) itemView.findViewById(R.id.txtQuestion);

            btnEdit = (ImageButton) itemView.findViewById(R.id.btnEdit);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);

            layoutOptions = (LinearLayout) itemView.findViewById(R.id.layoutOptions);


            itemView.setOnClickListener(this);
            btnEdit.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == btnEdit.getId()){

                if(viewTxtQuestion.getVisibility() == View.VISIBLE){
                    viewTxtQuestion.setVisibility(View.INVISIBLE);
                    editTxtQuestion.setVisibility(View.VISIBLE);
                    btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryConsultant), android.graphics.PorterDuff.Mode.SRC_IN);
                    return;
                }

                viewTxtQuestion.setVisibility(View.VISIBLE);
                editTxtQuestion.setVisibility(View.INVISIBLE);
                btnEdit.setColorFilter(ContextCompat.getColor(context, R.color.efab_disabled_text), android.graphics.PorterDuff.Mode.SRC_IN);

            }else if(view.getId() == btnDelete.getId()){
                new MaterialAlertDialogBuilder(context, R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Confirm to delete")
                        .setMessage("Are your sure want delete "+viewTxtQuestion.getText() + " ?")

                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int idx = 0;

                                while (idx < questionList.size())
                                {
                                    if(questionList.get(idx).getTimeStamp() == viewTxtQuestion.getTag())
                                    {
                                        // Remove item
                                        questionList.remove(idx);
                                    }
                                    else
                                    {
                                        ++idx;
                                    }
                                }
                                notifyDataSetChanged();
                            }
                        })
                        .show();
            }
        }



        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

}
