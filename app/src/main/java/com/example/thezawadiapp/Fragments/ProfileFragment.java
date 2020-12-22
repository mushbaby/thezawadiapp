package com.example.thezawadiapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thezawadiapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {


    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    View view;
    ImageView ivProfile;
    TextView tv_currentuserName, tv_contactCurrentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_profile, container, false);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();


        tv_currentuserName = view.findViewById(R.id.tv_currentuserName);
        tv_contactCurrentUser = view.findViewById(R.id.tv_contactCurrentUser);
        ivProfile = view.findViewById(R.id.ivProfile);

        tv_currentuserName.setText(currentUser.getDisplayName());
        tv_contactCurrentUser.setText(currentUser.getEmail());
        Glide.with(this).load(currentUser.getPhotoUrl()).into(ivProfile);
        return view;



    }


}