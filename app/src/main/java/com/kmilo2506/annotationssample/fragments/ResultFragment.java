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
 * Created by Camilo Sepulveda on 1/27/16.
 */

/**
 * Use @EFragment and pass the fragment's layout as a parameter
 * to avoid manually inflating it.
 */
@EFragment(R.layout.result_layout)
public class ResultFragment extends Fragment{

    private static final String ARG_BMI="bmi";

    private double mBmi;

    /**
     * Use @ViewById to avoid manually finding and casting your views.
     */
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

        /**
         * IMPORTANT: You can't access your views from onCreate or onCreateView
         * since at the point these methods are called your views HAVE NOT been
         * instantiated yet. When you need to access your views you need to
         * use the @AfterViews annotation or else you'll get a
         * NullPointerException on each view you have declared.
         */
    }

    /**
     * The @AfterViews annotation is used to specify which methods must be
     * called AFTER all your views have been instantiated. You can safely
     * use your views in methods with this annotation. In this case, we
     * set the text for mTextBmi with the result we obtained from FormFragment here
     * instead of doing it in onCreateView.
     */
    @AfterViews
    void setBmiText(){
        String BMI_FORMAT = "%2.02f";
        mTextBmi.setText(String.format(new Locale("EN", "en"), BMI_FORMAT, mBmi));
    }
}
