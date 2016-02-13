package com.asu.pick_me_graduation_project.controller;

import android.content.Context;
import android.os.Handler;

import com.asu.pick_me_graduation_project.callback.GetProfileCallback;
import com.asu.pick_me_graduation_project.model.User;
import com.asu.pick_me_graduation_project.utils.Constants;

/**
 * Created by ahmed on 2/7/2016.
 * manages general requests made by user
 */
public class UserApiController
{
    /* fields */
    Context context;

    /* constructor */
    public UserApiController(Context context)
    {
        this.context = context;
    }

    /* methods */

    /**
     * gets the profile info of a specific user
     */
    public void getProfile(String userId, final GetProfileCallback callback)
    {
        // make a delay to mock the request
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                // make mock data
                User user = new User();
                user.setEmail("egor@mail.com");
                user.setUserName("Egor");
                user.setFullName("Egor Kulikov");
                user.setProfilePictureUrl("http://graph.facebook.com/100001144443949/picture?type=square");
                user.setGender(Constants.GENDER_MALE);
                user.setLocationLatitude(30.0412772);
                user.setLocationAltitude(31.2658458);

                // invoke callback
                callback.success(user);

            }
        }, 1000);
    }
}