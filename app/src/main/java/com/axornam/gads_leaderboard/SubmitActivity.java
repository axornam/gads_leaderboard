package com.axornam.gads_leaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.axornam.gads_leaderboard.apiutil.SubmitAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {
    private Button mGoBackBtn;
    private Button mSubmitProjectBtn;
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mEmailAddressEditText;
    private EditText mGithubLinkEditText;

    private String mFirstName;
    private String mLastName;
    private String mEmailAddress;
    private String mGithubLink;

    private static final String TAG = "SubmitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        mFirstNameEditText = findViewById(R.id.first_name_input);
        mLastNameEditText = findViewById(R.id.last_name_input);
        mEmailAddressEditText = findViewById(R.id.email_address_input);
        mGithubLinkEditText = findViewById(R.id.gitub_link_input);

        mGoBackBtn = findViewById(R.id.goBackBtn);
        mGoBackBtn.setOnClickListener(view -> SubmitActivity.super.onBackPressed());

        mSubmitProjectBtn = findViewById(R.id.submit_project_btn);
        mSubmitProjectBtn.setOnClickListener(view -> {
            showSubmitConfirmDialog();
        });
    }

    private void showSubmitConfirmDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View myView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_confirm, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(myView);
        dialog.show();

//        // use generic dialog to show comfirm message
//        View myView = showGenericDialog(R.layout.alert_confirm);

        Button closeAlert = myView.findViewById(R.id.close_alert);
        closeAlert.setOnClickListener(view -> dialog.dismiss());

        Button finalSubmit = myView.findViewById(R.id.submit_yes);
        finalSubmit.setOnClickListener((View.OnClickListener) v -> {
            // Launch The Function that submit the final project details

            mFirstName = mFirstNameEditText.getText().toString();
            mLastName = mLastNameEditText.getText().toString();
            mEmailAddress = mEmailAddressEditText.getText().toString();
            mGithubLink = mGithubLinkEditText.getText().toString();

            submitTheProject(mFirstName, mLastName, mEmailAddress, mGithubLink);
            dialog.dismiss();
            mFirstNameEditText.setText("");
            mLastNameEditText.setText("");
            mEmailAddressEditText.setText("");
            mGithubLinkEditText.setText("");
            Toast.makeText(getApplicationContext(), "Submitting Project", Toast.LENGTH_LONG).show();

        });

    }

    private void submitTheProject(String firstName, String lastName, String emailAddress, String githubLink) {
        Call<Void> call = SubmitAPIClient.getService().submitProject(emailAddress, firstName, lastName, githubLink);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: Submission Code: " + response.code());
                    showSubmitSuccessDialog();
                } else {
                    showSubmitFailDialog();
                }
            }

            @Override
            public void onFailure(@Nullable Call<Void> call, @Nullable Throwable t) {
                showSubmitFailDialog();
            }
        });
    }

    private void showGenericDialog(int alert_type) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View myView = LayoutInflater.from(getApplicationContext()).inflate(alert_type, null);
        final AlertDialog dialog = builder.create();
        dialog.setView(myView);
        dialog.show();
    }

    private void showSubmitSuccessDialog() {
        showGenericDialog(R.layout.alert_success);
    }

    private void showSubmitFailDialog() {
        showGenericDialog(R.layout.alert_failure);
    }
}