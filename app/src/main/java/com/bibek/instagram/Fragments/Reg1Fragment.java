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

public class Reg1Fragment extends Fragment {

    Button btnNext;
    EditText phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reg_i, container, false);

        btnNext = view.findViewById(R.id.btnRegPhone);
        phone = view.findViewById(R.id.etRegPhone);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerWithPhone(phone.getText().toString());
            }
        });

        return view;
    }

    private void registerWithPhone(String phone) {

        Intent finalRegWithPhone = new Intent(getContext(), Register2Activity.class);
        finalRegWithPhone.putExtra("regWithPhone", phone);
        Register2Activity.phoneOrEmail = 1;
        startActivity(finalRegWithPhone);
    }

}
