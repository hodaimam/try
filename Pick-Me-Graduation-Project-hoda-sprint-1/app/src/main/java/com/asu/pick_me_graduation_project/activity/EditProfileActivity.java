package com.asu.pick_me_graduation_project.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.asu.pick_me_graduation_project.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditProfileActivity extends BaseActivity
{


    @Bind(R.id.Name)
    EditText Name;
    @Bind(R.id.Lastname)
    EditText Lastname;
    @Bind(R.id.Email)
    EditText Email;
    @Bind(R.id.CountryCode)
    EditText CountryCode;
    @Bind(R.id.Phonenumber)
    TextView Phonenumber;
    @Bind(R.id.Bio)
    EditText Bio;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ProfilePic)
    View ProfilePic;



    @Bind(R.id.content)
    LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_settings);

        // reference views
        ButterKnife.bind(this);

        // setup common views
        setupNavigationBar(this, toolbar);
        toolbar.setTitle(getString(R.string.title_edit_profile));

    }
}
