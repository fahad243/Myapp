package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private ImageView myImageView;
    private Button myButton;
    private Button openFeedbackButton;
    private Button openFormButton;
    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setOnClickListeners();
    }

    private void initializeViews() {
        myTextView = findViewById(R.id.myTextView);
        myImageView = findViewById(R.id.myImageView);
        myButton = findViewById(R.id.myButton);
        openFeedbackButton = findViewById(R.id.openfeedbackButton);
        openFormButton = findViewById(R.id.openformButton);
    }

    private void setOnClickListeners() {
        myButton.setOnClickListener(v -> toggleImage());

        openFeedbackButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FeedBackActivity.class);
            startActivity(intent);
        });

        openFormButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormActivity.class);
            startActivity(intent);
        });
    }

    private void toggleImage() {
        if (isFirstImage) {
            myImageView.setImageResource(R.drawable.welcome);
            myTextView.setText("Image 1 is displayed");
            Toast.makeText(MainActivity.this, "Image 1", Toast.LENGTH_SHORT).show();
        } else {
            myImageView.setImageResource(R.drawable.hi);
            myTextView.setText("Image 2 is displayed");
            Toast.makeText(MainActivity.this, "Image 2", Toast.LENGTH_SHORT).show();
        }
        isFirstImage = !isFirstImage;
    }
}