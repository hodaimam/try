package com.asu.pick_me_graduation_project.activity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.asu.pick_me_graduation_project.R;
import com.asu.pick_me_graduation_project.callback.CreateCommunityCallback;
import com.asu.pick_me_graduation_project.callback.SignUpCallback;
import com.asu.pick_me_graduation_project.controller.AuthenticationAPIController;
import com.asu.pick_me_graduation_project.controller.CommunityAPIController;
import com.asu.pick_me_graduation_project.model.Community;
import com.asu.pick_me_graduation_project.model.User;
import com.asu.pick_me_graduation_project.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateCommunityFragment  extends android.support.v4.app.DialogFragment
{

    AlertDialog addcommunityDialog;
    @Bind(R.id.comm_name)
    EditText comm_name;
    @Bind(R.id.comm_desc)
    EditText comm_desc;
   // @Bind(R.id.progressBar)
    //ProgressBar progressBar;


    /* UI */
    private View rootView;
    private AlertDialog createCommunityDialog;
   // private String userId;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.community_add, null);


        // create the dialog
        createCommunityDialog = new AlertDialog.Builder(getContext())
                .setView(rootView)
                .setTitle(getString(R.string.add_community))
                .setPositiveButton(R.string.add, null)
                .setNegativeButton(R.string.cancel, null)
                .create();

        ButterKnife.bind(this, rootView);


        return createCommunityDialog;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        // super.onStart() is where dialog.show() is actually called on the underlying dialog,
        // so we have to do it after this point to prevent positive button listener rom dismissing the dialog
        AlertDialog d = (AlertDialog) getDialog();
        if (d != null)
        {
            Button positiveButton = (Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    createCommunity();

                    //test
                    Intent intent = new Intent(getContext(),CommunityProfile.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
            });
        }
    }

    /**
     * asks the back end to create a new community
     */
    private void createCommunity()
    {
       /* // gather data
        String name = comm_name.getText().toString();
        String desc = comm_desc.getText().toString();

        // create
        progressBar.setVisibility(View.VISIBLE);
        CommunityAPIController controller = new CommunityAPIController(getContext());
        controller.createCommunity(userId,name, desc, new CreateCommunityCallback()
        {

            @Override
            public void success(Community community)
            {
                // show succes
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), getString(R.string.success), Toast.LENGTH_SHORT).show();

                // open the communityprofile
                Intent intent = new Intent(getContext(),CommunityProfile.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }

            @Override
            public void fail(String message)
            {
                // show error
                progressBar.setVisibility(View.GONE);
                Snackbar.make(content, message, Snackbar.LENGTH_SHORT).show();
            }
        });
        */


    }

}

