package com.kmilo2506.annotationssample.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.kmilo2506.annotationssample.fragments.ResultFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by Camilo Sepulveda on 1/27/16.
 */

/**
 * Here, @EActivity annotation seems pointless since there are
 * no other annotations specified in this activity. However,
 * take a look at the first line in newIntent(Context context, double bmi)
 */
@EActivity
public class ResultActivity extends SingleFragmentActivity {

    private static final String EXTRA_BMI = "com.kmilo2506.annotationssample.bmi";

    /**
     * Creates a new Intent with the BMI as an extra.
     * @param context The calling activity's context
     * @param bmi The BMI value
     * @return An intent
     */
    public static Intent newIntent(Context context, double bmi) {
        /**
         * Here, instead of manually creating an Intent, we use
         * Activity_.intent(Context).get() to get an intent for
         * ResultActivity. This is only possible because of
         * the @EActivity annotation since Activity_.intent(Context)
         * is built into all annotated activities.
         */
        Intent intent = ResultActivity_.intent(context).get();
        intent.putExtra(EXTRA_BMI, bmi);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        double bmi = (double) getIntent().getSerializableExtra(EXTRA_BMI);
        return ResultFragment_.newInstance(bmi);
    }
}
