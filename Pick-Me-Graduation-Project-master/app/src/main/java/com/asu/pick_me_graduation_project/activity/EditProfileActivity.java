package com.asu.pick_me_graduation_project.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.asu.pick_me_graduation_project.R;
import com.asu.pick_me_graduation_project.callback.GetProfileCallback;
import com.asu.pick_me_graduation_project.callback.SetProfileCallback;
import com.asu.pick_me_graduation_project.controller.AuthenticationAPIController;
import com.asu.pick_me_graduation_project.controller.UserApiController;
import com.asu.pick_me_graduation_project.model.User;
import com.asu.pick_me_graduation_project.utils.Constants;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class EditProfileActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Bind(R.id.content)
    LinearLayout content;
    @Bind(R.id.carcontent)
    LinearLayout carcontent;


    @Bind(R.id.Name)
    EditText firstname;
    @Bind(R.id.Lastname)
    EditText lastname;
    @Bind(R.id.Age)
    EditText age;
    @Bind(R.id.Email)
    EditText email;
    @Bind(R.id.Phonenumber)
    EditText phonenumber;
    @Bind(R.id.Bio)
    EditText bio;
    @Bind(R.id.CarBrand)
    Spinner carbrand;
    @Bind(R.id.CarModel)
    EditText carmodel;
    @Bind(R.id.CarYear)
    EditText caryear;
    @Bind(R.id.CarPlate)
    EditText carplate;


    /* fields */
    private String userId;
    private Switch mySwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // reference views
        ButterKnife.bind(this);

        // setup common views
        setupNavigationBar(this, toolbar);
        toolbar.setTitle(getString(R.string.title_edit_profile));

        mySwitch = (Switch) findViewById(R.id.Carswitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {

                    carcontent.setVisibility(View.VISIBLE);


                } else {

                    carcontent.setVisibility(View.INVISIBLE);
                }

            }
        });
        // get user id
       //userId = getIntent().getExtras().getString(Constants.USER_ID);
        //loadProfile();
        /*String[] mobileArray = {"Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};
         ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.dialog_brand_list, mobileArray);
         ListView listView = (ListView) findViewById(R.id.dialogBrandList);
        listView.setAdapter(adapter);
        final Context context = this;
        carbrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(R.layout.);
                dialog.setContentView(R.layout.brandcontent);
                dialog.dismiss();


            }
        });

*/
    }
    /**
     * downloads the user's profile and shows it
     */
    private void loadProfile()
    {
        UserApiController controller = new UserApiController(getApplicationContext());
        controller.getProfile(userId, new GetProfileCallback()
        {
            @Override
            public void success(User user)
            {
                //  set profile data to views
                firstname.setText(user.getFirstName());
                lastname.setText(user.getLastName());
                email.setText(user.getEmail());
                phonenumber.setText(user.getPhoneNumber());
                bio.setText(user.getBio());
              //  Picasso.with(getApplicationContext()).
              //          load(user.getProfilePictureUrl())
              //          .transform(new CircleTransform())
              //          .into(imageViewProfilePicture);
                // TODO age
                //age.setText(user.getAge());
                carmodel.setText(user.getCarDetails().getModel());
                caryear.setText(user.getCarDetails().getYear());
                carplate.setText(user.getCarDetails().getPlateNumber());
                //iamgeViewCarIsConditioned.setImageResource(Integer.parseInt(String.valueOf(user.getCarDetails().isConditioned())));//not sure



            }

            @Override
            public void fail(String message)
            {
                //  show error using snack bar
                //done by ra2fat imported linearLayout and make linearLayput content
                Snackbar.make(content, message, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
/*
    private void SaveProfile()
    {
        //  set profile data to views
       User user = new User();
        user.setFirstName(firstname.getText().toString());
        user.setLastName(lastname.getText().toString());
        user.setEmail(lastname.getText().toString());
        user.setPhoneNumber(phonenumber.getText().toString());
        user.setBio(bio.getText().toString());

        //  Picasso.with(getApplicationContext()).
        //          load(user.getProfilePictureUrl())
        //          .transform(new CircleTransform())
        //          .into(imageViewProfilePicture);
        // TODO age
        //age.setText(user.getAge());
        user.setMoodel(carmodel.getText().toString());
        user.setBrand(carbrand.getText().toString());
        user.setPlaeNumber(carplate.getText().toString());


        UserApiController controller = new UserApiController(getApplicationContext());
        controller.editProfile(user, new SetProfileCallback()
        {
            @Override
            public void success(User user)
            {
                //iamgeViewCarIsConditioned.setImageResource(Integer.parseInt(String.valueOf(user.getCarDetails().isConditioned())));//not sure



            }

            @Override
            public void fail(String message)
            {
                //  show error using snack bar
                //done by ra2fat imported linearLayout and make linearLayput content
                Snackbar.make(content, message, Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    */

}
