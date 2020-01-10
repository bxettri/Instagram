package com.bibek.instagram.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bibek.instagram.R;
import com.bibek.instagram.Activity.Register2Activity;

public class Reg2Fragment extends Fragment {

    Button btnNext;
    EditText email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reg_ii, container, false);

        btnNext = view.findViewById(R.id.btnRegEmail);
        email = view.findViewById(R.id.etRegEmail);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerWithEmail(email.getText().toString());
            }
        });

        return view;
    }

    private void registerWithEmail(String email) {

        Intent finalRegWithEmail = new Intent(getContext(), Register2Activity.class);
        finalRegWithEmail.putExtra("regWithEmail", email);
        Register2Activity.phoneOrEmail = 2;
        startActivity(finalRegWithEmail);

    }

}
