package com.example.myapp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private ImageView myImageView;
    private Button myButton;
    private Button openFeedbackButton;
    private Button openFormButton;
    private Button openFormList;
    private Button openFormRecyclerView;

    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeViews();


        if (!areViewsValid()) {
            throw new RuntimeException("One or more UI components are missing in the layout file.");
        }


        setOnClickListeners();
    }

    private void initializeViews() {
        myTextView = findViewById(R.id.myTextView);
        myImageView = findViewById(R.id.myImageView);
        myButton = findViewById(R.id.myButton);
        openFeedbackButton = findViewById(R.id.openfeedbackButton);
        openFormButton = findViewById(R.id.openformButton);
        openFormList = findViewById(R.id.openformList);
        openFormRecyclerView = findViewById(R.id.openformRecyclerView);
    }

    private boolean areViewsValid() {
        return myTextView != null &&
                myImageView != null &&
                myButton != null &&
                openFeedbackButton != null &&
                openFormButton != null &&
                openFormList != null;
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


        openFormList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        openFormRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
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
