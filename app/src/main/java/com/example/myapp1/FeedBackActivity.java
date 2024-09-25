package com.example.myapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FeedBackActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private SeekBar seekBarSatisfaction;
    private CheckBox checkFeature1, checkFeature2;
    private Switch switchRecommend;
    private Button submitButton;
    private TextView satisfactionLevelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);


        ratingBar = findViewById(R.id.ratingBar);
        seekBarSatisfaction = findViewById(R.id.seekBarSatisfaction);
        checkFeature1 = findViewById(R.id.checkFeature1);
        checkFeature2 = findViewById(R.id.checkFeature2);
        switchRecommend = findViewById(R.id.switchRecommend);
        submitButton = findViewById(R.id.submitButton);
        satisfactionLevelText = findViewById(R.id.satisfactionLabel);


        seekBarSatisfaction.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                satisfactionLevelText.setText("Satisfaction level: " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        submitButton.setOnClickListener(v -> {

            float rating = ratingBar.getRating();
            int satisfactionLevel = seekBarSatisfaction.getProgress();
            boolean isFeature1Checked = checkFeature1.isChecked();
            boolean isFeature2Checked = checkFeature2.isChecked();
            boolean wouldRecommend = switchRecommend.isChecked();


            String feedbackSummary = "Rating: " + rating + "\n" +
                    "Satisfaction Level: " + satisfactionLevel + "%" + "\n" +
                    "Service was fast: " + (isFeature1Checked ? "Yes" : "No") + "\n" +
                    "Service was friendly: " + (isFeature2Checked ? "Yes" : "No") + "\n" +
                    "Would recommend: " + (wouldRecommend ? "Yes" : "No");

            Toast.makeText(FeedBackActivity.this, feedbackSummary, Toast.LENGTH_LONG).show();


        });
    }
}