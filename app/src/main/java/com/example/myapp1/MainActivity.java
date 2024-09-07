package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
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
    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = findViewById(R.id.myTextView);
        myImageView = findViewById(R.id.myImageView);
        myButton = findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }
}