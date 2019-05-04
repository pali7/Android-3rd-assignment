package com.example.fragmentsviewpager.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragmentsviewpager.R;

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText etUsername, etPassword, etConfirmPassword;
    private Button btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        etUsername = v.findViewById(R.id.etUsername);
        etPassword = v.findViewById(R.id.etPassword);
        etConfirmPassword = v.findViewById(R.id.etConfirmPassword);
        btnRegister = v.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        SharedPreferences prefs = getActivity().getSharedPreferences("My_Prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
        Toast.makeText(getActivity(), "User Created..", Toast.LENGTH_SHORT).show();
    }
}
