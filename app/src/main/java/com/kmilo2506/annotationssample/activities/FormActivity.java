package com.kmilo2506.annotationssample.activities;

import android.support.v4.app.Fragment;

import com.kmilo2506.annotationssample.fragments.FormFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by kmilo2506 on 1/27/16.
 */

@EActivity
public class FormActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FormFragment_();
    }
}
