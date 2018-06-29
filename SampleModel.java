package com.solvedge.androidsampleexamples;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hariharan on 6/28/2018.
 */

public class SampleModel implements Parcelable{

    private String sample;
    private String isSelected;

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String isSelected() {
        return isSelected;
    }

    public void setSelected(String selected) {
        isSelected = selected;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sample);
        dest.writeString(String.valueOf(isSelected));
    }

    public static final Parcelable.Creator<SampleModel> CREATOR = new Parcelable.Creator<SampleModel>() {
        public SampleModel createFromParcel(Parcel in) {
            return new SampleModel(in);
        }

        public SampleModel[] newArray(int size) {
            return new SampleModel[size];
        }
    };

    private SampleModel(Parcel in) {
        sample = in.readString();
        isSelected = in.readString();
    }

    public SampleModel(String sample,String isSelected){
        this.sample = sample;
        this.isSelected = isSelected;
    }
}
