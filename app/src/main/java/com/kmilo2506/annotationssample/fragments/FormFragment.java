package com.kmilo2506.annotationssample.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

import com.kmilo2506.annotationssample.R;
import com.kmilo2506.annotationssample.activities.ResultActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by kmilo2506 on 1/27/16.
 */

@EFragment(R.layout.form_layout)
public class FormFragment extends Fragment {

    @ViewById(R.id.edit_weight)
    EditText mWeight;

    @ViewById(R.id.edit_height)
    EditText mHeight;

    @ViewById(R.id.button_calc_bmi)
    Button mCalcBmi;

    @Click(R.id.button_calc_bmi)
    void calcBmi(){
        double bmi = Integer.valueOf(mWeight.getText().toString()) /
                (Float.valueOf(mHeight.getText().toString()) * Float.valueOf(mHeight.getText().toString()));

        Intent intent = ResultActivity_.newIntent(getActivity(), bmi);
        startActivity(intent);
    }

}
