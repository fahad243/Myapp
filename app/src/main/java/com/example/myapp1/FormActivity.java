package com.example.myapp1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText nameEditText, studentIdEditText, emailEditText, phoneNumberEditText, passwordEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        nameEditText = findViewById(R.id.nameEditText);
        studentIdEditText = findViewById(R.id.studentIdEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = nameEditText.getText().toString().trim();
        String studentId = studentIdEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phoneNumber = phoneNumberEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            nameEditText.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(studentId)) {
            studentIdEditText.setError("Student ID is required");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Email is required");
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Enter a valid email");
            return;
        }

        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("Mobile number is required");
            return;
        }

        if (phoneNumber.length() != 11) {
            phoneNumberEditText.setError("Enter a valid 10-digit mobile number");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }

        String formData = "Name: " + name + "\n" +
                "Student ID: " + studentId + "\n" +
                "Email: " + email + "\n" +
                "Mobile: " + phoneNumber;

        Toast.makeText(FormActivity.this, formData, Toast.LENGTH_LONG).show();
        clearForm();
    }

    private void clearForm() {
        nameEditText.setText("");
        studentIdEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
        passwordEditText.setText("");
    }
}