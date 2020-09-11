package com.axornam.gads_leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubmitActivity extends AppCompatActivity {
    private Button mGoBackBtn;
    private Button mSubmitProjectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mGoBackBtn = findViewById(R.id.goBackBtn);
        mGoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitActivity.super.onBackPressed();
            }
        });

        mSubmitProjectBtn = findViewById(R.id.submit_project_btn);
        mSubmitProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Submitting Project", Toast.LENGTH_SHORT).show();
                showSubmitDialog();
            }
        });
    }

    private void showSubmitDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View myView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_confirm, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(myView);

        dialog.show();

        Button closeAlert = myView.findViewById(R.id.close_alert);
        closeAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Button finalSubmit = myView.findViewById(R.id.submit_yes);
        finalSubmit.setOnClickListener((View.OnClickListener) v -> {
            // Launch The Function that submit the final project details
            submitTheProject("Richard", "lastname", "email@address", "gitub.link");
            dialog.dismiss();
        });

    }

    private void submitTheProject(String firstName, String lastName, String emailAddress, String githubLink) {
        showSubmitSuccessDialog();
    }

    private void showSubmitSuccessDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View myView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_success, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(myView);

        dialog.show();
    }

    private void showSubmitFailDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View myView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_failure, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(myView);

        dialog.show();
    }
}