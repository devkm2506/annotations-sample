package com.kmilo2506.annotationssample.activities;

import android.support.v4.app.Fragment;

import com.kmilo2506.annotationssample.fragments.FormFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by Camilo Sepulveda on 1/27/16.
 */

/* @EActivity annotation is necessary so you can use the
 * other annotations in your activities, fragments etc.
 */
@EActivity
public class FormActivity extends SingleFragmentActivity {

    /* Here you return a new FormFragment so SingleFragmentActivity 
     * can add it to the FragmentManager and present it when the
     * activity is created.
     */
    @Override
    protected Fragment createFragment() {
        /* Notice the underscore at the end of the fragment's name.
         * When using the @EActivity or @EFragment annotations, 
         * the framework creates new classes at compile time with 
         * the same name as your fragments and activities but with
         * an underscore at the end. This is why when you need to 
         * reference this activities or fragments you must put an
         * underscore at the end of their names.
         */
        return new FormFragment_();
    }
}
