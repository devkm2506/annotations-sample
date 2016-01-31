package com.kmilo2506.annotationssample.activities;

import android.support.v4.app.Fragment;

import com.kmilo2506.annotationssample.fragments.FormFragment_;

import org.androidannotations.annotations.EActivity;

/**
 * Created by Camilo Sepulveda on 1/27/16.
 */

/**
 * The @EActivity annotation allows you to use the
 * other annotations in your activities among other
 * things. You can also pass the activities layout
 * as a parameter like this:
 *
 *      "@EActivity(R.layout.some_activity_layout)"
 */
@EActivity
public class FormActivity extends SingleFragmentActivity {

    /**
     * Here you return a new FormFragment so SingleFragmentActivity
     * can add it to the FragmentManager and present it when the
     * activity is created.
     */
    @Override
    protected Fragment createFragment() {
        /**
         * Notice the underscore at the end of the fragment's name.
         * When using the @EActivity or @EFragment annotations,
         * the framework creates new classes at compile time using
         * the same name as your annotated fragments but adding
         * an underscore at the end of it. When you need to
         * reference your fragments, you MUST reference the
         * underscored ones.
         */
        return new FormFragment_();
    }
}
