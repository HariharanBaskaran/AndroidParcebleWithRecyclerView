package com.solvedge.androidsampleexamples;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hariharan on 6/28/2018.
 */

public class SampleListAdapter extends RecyclerView.Adapter<SampleListAdapter.MyViewHolder> {


    private ArrayList<SampleModel> sampleList;
    private Context context;
    private LayoutInflater inflater;
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();

    public SampleListAdapter(Context context, ArrayList<SampleModel> sampleList) {
        this.context = context;
        this.sampleList = sampleList;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sample_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }

    public ArrayList<SampleModel> getSampleModelList() {
        return sampleList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSave;
        private CheckBox check;

        public MyViewHolder(View view) {
            super(view);

            tvSave = (TextView) view.findViewById(R.id.tvSave);
            check = (CheckBox) view.findViewById(R.id.checkbox);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    saveCheckBoxState(adapterPosition);
                }
            });

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();
                    saveCheckBoxState(adapterPosition);
                }
            });


        }

        void bind(int position) {
            if (!itemStateArray.get(position, false)) {
                check.setChecked(false);
            } else {
                check.setChecked(true);
            }
            tvSave.setText(sampleList.get(position).getSample());
            if(sampleList.get(position).isSelected().equals("True")){
                check.setChecked(true);
            }else{
                check.setChecked(false);
            }

        }

        public void saveCheckBoxState(int adapterPosition){
            if (!itemStateArray.get(adapterPosition, false)) {
                check.setChecked(true);

                sampleList.get(adapterPosition).setSelected("True");
                itemStateArray.put(adapterPosition, true);
            } else {

                check.setChecked(false);
                sampleList.get(adapterPosition).setSelected("False");
                itemStateArray.put(adapterPosition, false);
            }
        }
    }
}

