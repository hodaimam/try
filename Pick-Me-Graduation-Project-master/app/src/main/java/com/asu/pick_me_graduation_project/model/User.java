package com.asu.pick_me_graduation_project.model;

import android.util.Log;

import com.asu.pick_me_graduation_project.utils.Constants;

import org.json.JSONObject;

/**
 * Created by ahmed on 2/7/2016.
 */
public class User
{
    /* fields */
    String userId;
    String firstName;
    String email;
    String lastName;
    String profilePictureUrl;
    double locationLatitude;
    double locationAltitude;
    String gender;
    String phoneNumber;
    String bio;
    CarDetails carDetails;
    private int rate;

    /* setters and getters */

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public double getLocationAltitude()
    {
        return locationAltitude;
    }

    public void setLocationAltitude(double locationAltitude)
    {
        this.locationAltitude = locationAltitude;
    }

    public double getLocationLatitude()
    {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude)
    {
        this.locationLatitude = locationLatitude;
    }

    public String getProfilePictureUrl()
    {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl)
    {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public CarDetails getCarDetails()
    {
        return carDetails;
    }

    public void setCarDetails(CarDetails carDetails)
    {
        this.carDetails = carDetails;
    }

    public int getRate()
    {
        return rate;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }

    /* methods */

    /**
     * parses a json to get a user object
     */
    public static User fromJson(JSONObject json)
    {
        User user = new User();

        try
        {
            user.setUserId(json.getString("id"));
            user.setEmail(json.getString("email"));
            user.setFirstName(json.getString("firstName"));
            user.setLastName(json.getString("lastName"));
            user.setProfilePictureUrl(json.getString("profilePicture"));
            user.setGender(json.getBoolean("gender") ? Constants.GENDER_MALE : Constants.GENDER_FEMALE_);
            user.setBio(json.getString("bio"));
            user.setPhoneNumber(json.getString("phoneNumber"));
            CarDetails carDetails = new CarDetails();
            carDetails.setPlateNumber(json.getString("carPlateNumber"));
            carDetails.setModel(json.getString("carModel"));
            carDetails.setYear(json.getString("carYear"));
            if (!json.isNull("carAC"))
                carDetails.setConditioned(json.getBoolean("carAC"));
            user.setCarDetails(carDetails);

        } catch (Exception e)
        {
            Log.e("Game", "error parsing user" + e.getMessage());
        }
        return user;
    }


}
