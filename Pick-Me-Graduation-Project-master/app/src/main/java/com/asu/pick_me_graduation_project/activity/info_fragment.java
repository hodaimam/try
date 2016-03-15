package com.asu.pick_me_graduation_project.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asu.pick_me_graduation_project.R;

/**
 * Created by ahmed on 3/14/2016.
 */
public class info_fragment extends Fragment {

    public info_fragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.info_fragment, container, false);
        }

    }


