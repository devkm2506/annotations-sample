package com.kmilo2506.annotationssample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.kmilo2506.annotationssample.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Locale;

/**
 * Created by kmilo2506 on 1/27/16.
 */

@EFragment(R.layout.result_layout)
public class ResultFragment extends Fragment{

    private static final String ARG_BMI="bmi";
    private final String BMI_FORMAT = "%2.02f";

    private double mBmi;

    @ViewById(R.id.text_bmi)
    TextView mTextBmi;

    public static ResultFragment newInstance(double bmi) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BMI, bmi);

        ResultFragment fragment = new ResultFragment_();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBmi = (double) getArguments().getSerializable(ARG_BMI);
    }

    @AfterViews
    void setBmiText(){
        mTextBmi.setText(String.format(new Locale("EN", "en"), BMI_FORMAT, mBmi));
    }
}
