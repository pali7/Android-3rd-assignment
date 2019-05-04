package com.example.fragmentsviewpager.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.example.fragmentsviewpager.activities.DashboardActivity;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = v.findViewById(R.id.etUsername);
        etPassword = v.findViewById(R.id.etPassword);
        btnLogin = v.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        SharedPreferences prefs = getActivity().getSharedPreferences("My_Prefs", Context.MODE_PRIVATE);
        if (username.equals(prefs.getString("username", "")) &&
                password.equals(prefs.getString("password", ""))) {
            startActivity(new Intent(getActivity(), DashboardActivity.class));
            Toast.makeText(getActivity(), "Login Success.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Login Failed.", Toast.LENGTH_SHORT).show();
        }
    }
}
