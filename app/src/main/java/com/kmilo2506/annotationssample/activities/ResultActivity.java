package com.kmilo2506.annotationssample.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.kmilo2506.annotationssample.fragments.ResultFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by kmilo2506 on 1/27/16.
 */

@EActivity
public class ResultActivity extends SingleFragmentActivity {

    private static final String EXTRA_BMI = "com.kmilo2506.annotationssample.bmi";

    public static Intent newIntent(Context context, double bmi) {
        Intent intent = ResultActivity_.intent(context).get();
        intent.putExtra(EXTRA_BMI, bmi);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        double bmi = (double) getIntent().getSerializableExtra(EXTRA_BMI);
        return ResultFragment_.newInstance(bmi);
    }
}
